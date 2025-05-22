package com.mysite.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class CartItem {
    private Long id;
    private Long productId;
    private Long quantity;
    private BigDecimal price;
    private Long cartId;
    private Set<CartItemConfiguration> chosenConfiguration;

    public CartItem(Long id, Long productId, Long quantity, BigDecimal price, Long cartId, Set<CartItemConfiguration> chosenConfiguration) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.cartId = cartId;
        this.chosenConfiguration = chosenConfiguration;
    }

    public boolean isCartItemDataNull() {
        return Objects.isNull(this.getCartId()) ||
                Objects.isNull(this.getProductId()) ||
                Objects.isNull(this.getQuantity()) ||
                Objects.isNull(this.getPrice()) ||
                Objects.isNull(this.getChosenConfiguration());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return Objects.equals(productId, cartItem.productId) && Objects.equals(chosenConfiguration, cartItem.chosenConfiguration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, chosenConfiguration);
    }

    public CartItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<CartItemConfiguration> getChosenConfiguration() {
        return chosenConfiguration;
    }

    public void setChosenConfiguration(Set<CartItemConfiguration> chosenConfiguration) {
        this.chosenConfiguration = chosenConfiguration;
    }
}
