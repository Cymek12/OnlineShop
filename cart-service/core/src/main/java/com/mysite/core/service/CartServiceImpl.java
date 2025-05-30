package com.mysite.core.service;

import com.mysite.core.exception.CartDoesNotExists;
import com.mysite.core.exception.CartItemDoesNotExists;
import com.mysite.core.port.in.CartService;
import com.mysite.core.port.out.CartOperations;
import com.mysite.core.port.out.ProductOperations;
import com.mysite.model.*;
import com.mysite.modelpublic.command.AddProductToCartCommand;
import com.mysite.modelpublic.dto.product.ProductDTO;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartOperations cartOperations;
    private final ProductOperations productOperations;
    private final Clock clock;

    @Override
    public Cart addProductToCart(AddProductToCartCommand request) {
        validateAddProductToCartCommand(request);
        Cart cart = cartOperations.findByUserId(request.getUserId())
                .orElseGet(() -> createNewCart(request.getUserId()));

        CartItem newItem = buildCartItemFromRequest(request, cart.getId());
        newItem.setCartId(cart.getId());

        addOrUpdateCartItem(cart, newItem);

        updateCartTotalPrice(cart);
        cart.setUpdatedAt(LocalDateTime.now(clock));
        return cartOperations.save(cart);
    }

    private void validateAddProductToCartCommand(AddProductToCartCommand request) {
        if (request.getProductId() == null) {
            throw new IllegalArgumentException("Product ID must not be null.");
        }
        if (request.getQuantity() == null || request.getQuantity() <= 0) {
            throw new IllegalArgumentException("Product quantity must be greater than 0.");
        }
        if (request.getConfigurationIds() == null) {
            throw new IllegalArgumentException("Configuration list must not be null.");
        }
    }

    private Cart createNewCart(Long userId) {
        LocalDateTime now = LocalDateTime.now(clock);
        Cart newCart = new Cart();
        newCart.setUserId(userId);
        newCart.setAddedProducts(new ArrayList<>());
        newCart.setTotalPrice(BigDecimal.ZERO);
        newCart.setCreatedAt(now);
        newCart.setUpdatedAt(now);
        return cartOperations.save(newCart);
    }

    private CartItem buildCartItemFromRequest(AddProductToCartCommand request, Long cartId) {
        ProductDTO productDTO = productOperations.getProduct(String.valueOf(request.getProductId()));
        List<CartItemConfiguration> chosenConfigurations = mapChosenConfiguration(productDTO, request.getConfigurationIds(), cartId);

        BigDecimal configurationPrice = chosenConfigurations.stream()
                .map(CartItemConfiguration::getAdditionalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        CartItem cartItem = new CartItem();
        cartItem.setCartId(cartId);
        cartItem.setProductId(productDTO.getId());
        cartItem.setQuantity(request.getQuantity());
        cartItem.setChosenConfiguration(chosenConfigurations);
        cartItem.setPrice(productDTO.getPrice().add(configurationPrice));
        return cartItem;
    }

    private void addOrUpdateCartItem(Cart cart, CartItem newItem) {
        Optional<CartItem> existingItem = cart.getAddedProducts().stream()
                .filter(item -> isSameItem(item, newItem))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(existingItem.get().getQuantity() + newItem.getQuantity());
        } else {
            cart.getAddedProducts().add(newItem);
        }
    }

    private void updateCartTotalPrice(Cart cart) {
        BigDecimal total = cart.getAddedProducts().stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        cart.setTotalPrice(total);
    }

    private boolean isSameItem(CartItem a, CartItem b) {
        return a.getProductId().equals(b.getProductId())
                && isSameConfiguration(a.getChosenConfiguration(), b.getChosenConfiguration());
    }

    private boolean isSameConfiguration(List<CartItemConfiguration> a, List<CartItemConfiguration> b) {
        return new HashSet<>(a).equals(new HashSet<>(b));
    }

    private List<CartItemConfiguration> mapChosenConfiguration(ProductDTO productDTO, List<Long> configurationIds, Long cartItemId){
        return productDTO.getConfigurations().stream()
                .filter(config -> configurationIds.contains(config.getId()))
                .map(config -> {
                    CartItemConfiguration cartConfig = new CartItemConfiguration();
                    cartConfig.setConfigurationType(config.getName());
                    cartConfig.setValue(config.getValue());
                    cartConfig.setAdditionalPrice(config.getAdditionalPrice());
                    cartConfig.setCartItemId(cartItemId);
                    return cartConfig;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Cart deleteCartItem(Long cartId, Long cartItemId, Long quantity) {
        Cart cart = cartOperations.findById(cartId)
                .orElseThrow(() -> new CartDoesNotExists("Cart with id: " + cartId + " does not exist"));
        CartItem cartItem = cart.getAddedProducts().stream()
                .filter(item -> item.getId().equals(cartItemId))
                .findFirst()
                .orElseThrow(() -> new CartItemDoesNotExists("In cart with id: " + cartId + " item with id: " + cartItemId + " does not exist"));

        if (cartItem.getQuantity() > quantity) {
            cartItem.setQuantity(cartItem.getQuantity() - quantity);
        } else {
            cart.getAddedProducts().remove(cartItem);
        }
        updateCartTotalPrice(cart);
        cart.setUpdatedAt(LocalDateTime.now(clock));
        return cartOperations.save(cart);
    }

    @Override
    public Cart getCartById(Long id) {
        return cartOperations.findById(id)
                .orElseThrow(() -> new CartDoesNotExists("Cart with id: " + id + " does not exists"));
    }

    @Override
    public PageContent<Cart> getCarts(MyPageable myPageable) {
        return cartOperations.findAll(myPageable);
    }

    @Override
    public void deleteCart(Long id) {
        Cart cart = cartOperations.findById(id)
                .orElseThrow(() -> new CartDoesNotExists("Cart with id: " + id + " does not exists"));
        cartOperations.delete(cart);
    }
}
