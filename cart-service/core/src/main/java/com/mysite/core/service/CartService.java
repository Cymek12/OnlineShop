package com.mysite.core.service;

import com.mysite.core.exception.CartDoesNotExists;
import com.mysite.core.exception.CartItemDataIsNullException;
import com.mysite.core.exception.CartItemDoesNotExists;
import com.mysite.core.port.in.CartUseCase;
import com.mysite.core.port.out.CartPort;
import com.mysite.core.port.out.ProductPort;
import com.mysite.model.Cart;
import com.mysite.model.CartItem;
import com.mysite.model.CartItemConfiguration;
import com.mysite.modelpublic.command.AddProductToCartCommand;
import com.mysite.modelpublic.dto.ProductDTO;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CartService implements CartUseCase {
    private final CartPort cartPort;
    private final ProductPort productPort;

    public CartService(CartPort cartPort, ProductPort productPort) {
        this.cartPort = cartPort;
        this.productPort = productPort;
    }

    @Override
    public Cart addProductToCart(AddProductToCartCommand request) {
        Cart cart = cartPort.findByUserId(request.getUserId())
                .orElseGet(() -> createNewCart(request.getUserId()));

        CartItem newItem = toCartItem(request, cart.getId());
        newItem.setCartId(cart.getId());

        Optional<CartItem> existingItem = cart.getAddedProducts().stream()
                .filter(item -> isSameItem(item, newItem))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + newItem.getQuantity());
        } else {
            cart.getAddedProducts().add(newItem);
        }

        cart.setUpdatedAt(LocalDateTime.now());
        return cartPort.save(cart);
    }

    private boolean isSameItem(CartItem a, CartItem b) {
        return a.getProductId().equals(b.getProductId())
                && isSameConfiguration(a.getChosenConfiguration(), b.getChosenConfiguration());
    }

    private boolean isSameConfiguration(Set<CartItemConfiguration> a, Set<CartItemConfiguration> b) {
        if (a.size() != b.size()) return false;

        for (CartItemConfiguration configA : a) {
            boolean match = b.stream().anyMatch(configA::equals);
            if (!match) return false;
        }
        return true;
    }

    private CartItem toCartItem(AddProductToCartCommand request, Long cartId) {
        ProductDTO productDTO = productPort.getProduct(String.valueOf(request.getProductId()));
        CartItem cartItem = new CartItem();
        cartItem.setCartId(cartId);
        cartItem.setProductId(productDTO.getId());
        cartItem.setQuantity(request.getQuantity());

        Set<CartItemConfiguration> chosenConfigurations = mapChosenConfiguration(productDTO, request.getConfigurationIds(), cartId);

        cartItem.setChosenConfiguration(chosenConfigurations);
        return cartItem;
    }

    private Set<CartItemConfiguration> mapChosenConfiguration(ProductDTO productDTO, List<Long> configurationIds, Long cartId){
        return productDTO.getConfigurations().stream()
                .filter(config -> configurationIds.contains(config.getId()))
                .map(config -> {
                    CartItemConfiguration cartConfig = new CartItemConfiguration();
                    cartConfig.setId(config.getId());
                    cartConfig.setConfigurationType(config.getName());
                    cartConfig.setValue(config.getValue());
                    cartConfig.setAdditionalPrice(config.getAdditionalPrice());
                    cartConfig.setCartItemId(cartId);
                    return cartConfig;
                })
                .collect(Collectors.toSet());
    }

    private Cart createNewCart(Long userId) {
        Cart newCart = new Cart();
        newCart.setUserId(userId);
        newCart.setCreatedAt(LocalDateTime.now());
        newCart.setUpdatedAt(LocalDateTime.now());
        newCart.setAddedProducts(new HashSet<>());
        return cartPort.save(newCart);
    }

    private void validateCartItemData(CartItem cartItem) {
        if (cartItem.isCartItemDataNull()) {
            throw new CartItemDataIsNullException("CartIdem data cannot be null");
        }
    }

    @Override
    public void deleteCartItem(Long cartId, Long cartItemId, Long quantity) {
        Cart cart = cartPort.findById(cartId)
                .orElseThrow(() -> new CartDoesNotExists("Cart with id: " + cartId + " does not exist"));
        CartItem cartItem = cart.getAddedProducts().stream()
                .filter(item -> item.getId().equals(cartItemId))
                .findFirst()
                .orElseThrow(() -> new CartItemDoesNotExists("In cart with id: " + cartId + " item with id: " + cartItemId + " does not exist"));
        if (cartItem.getQuantity() > quantity) {
            cartItem.setQuantity(cartItem.getQuantity() - quantity);
            cartPort.save(cart);
        } else {
            cart.getAddedProducts().remove(cartItem);
            cartPort.save(cart);
        }
    }

    @Override
    public Cart getCartById(Long id) {
        return cartPort.findById(id)
                .orElseThrow(() -> new CartDoesNotExists("Cart with id: " + id + " does not exists"));
    }
}
