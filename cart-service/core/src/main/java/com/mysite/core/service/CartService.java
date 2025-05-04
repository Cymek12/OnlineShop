package com.mysite.core.service;

import com.mysite.core.exception.CartDoesNotExists;
import com.mysite.core.exception.CartItemDataIsNullException;
import com.mysite.core.exception.CartItemDoesNotExists;
import com.mysite.core.port.in.CartUseCase;
import com.mysite.core.port.out.CartItemPort;
import com.mysite.core.port.out.CartPort;
import com.mysite.model.Cart;
import com.mysite.model.CartItem;
import com.mysite.model.ProductConfiguration;
import com.mysite.modelpublic.command.AddProductToCartCommand;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartService implements CartUseCase {
    private final CartPort cartPort;
    private final CartItemPort cartItemPort;

    public CartService(CartPort cartPort, CartItemPort cartItemPort) {
        this.cartPort = cartPort;
        this.cartItemPort = cartItemPort;
    }

    @Override
    public Cart addProductToCart(AddProductToCartCommand request) {
        Cart cart = cartPort.findByUserId(request.getUserId())
                .orElseGet(() -> createNewCart(request.getUserId()));

        CartItem newItem = toCartItem(request);
        newItem.setCart(cart);

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

    private boolean isSameConfiguration(List<ProductConfiguration> a, List<ProductConfiguration> b) {
        if (a.size() != b.size()) return false;

        for (ProductConfiguration configA : a) {
            boolean match = b.stream().anyMatch(configB -> configA.equals(configB));
            if (!match) return false;
        }
        return true;
    }

    private CartItem toCartItem(AddProductToCartCommand request) {
        CartItem cartItem = new CartItem();
        cartItem.setProductId(request.getProductId());
        cartItem.setQuantity(request.getQuantity());
        cartItem.setPrice(request.getPrice());
        cartItem.setChosenConfiguration(request.getChosenConfiguration());
        return cartItem;
    }

    private Cart createNewCart(Long userId) {
        Cart newCart = new Cart();
        newCart.setUserId(userId);
        newCart.setCreatedAt(LocalDateTime.now());
        newCart.setUpdatedAt(LocalDateTime.now());
        newCart.setAddedProducts(new ArrayList<>());
        return cartPort.save(newCart);
    }

    private void validateCartItemData(CartItem cartItem) {
        if (!cartItem.isCartItemDataNull()) {
            throw new CartItemDataIsNullException("CartIdem data cannot be null");
        }
    }

    @Override
    public void deleteCartItem(Long cartId, Long cartItemId, Long quantity) {
        Cart cart = cartPort.findById(cartId)
                .orElseThrow(() -> new CartDoesNotExists("Cart with id: " + cartId + " does not exists"));
        CartItem cartItem = cart.getAddedProducts().stream()
                .filter(item -> item.getId().equals(cartItemId))
                .findFirst()
                .orElseThrow(() -> new CartItemDoesNotExists("In cart with id: " + cartId + " item with id: " + cartItemId + " does not exists"));
        if (cartItem.getQuantity() > quantity) {
            cartItem.setQuantity(cartItem.getQuantity() - quantity);
            cartItemPort.save(cartItem);
        } else if (cartItem.getQuantity() <= quantity) {
            cartItemPort.delete(cartItem);
        }
    }

    @Override
    public Cart getCartById(Long id) {
        return cartPort.findById(id)
                .orElseThrow(() -> new CartDoesNotExists("Cart with id: " + id + " does not exists"));
    }
}
