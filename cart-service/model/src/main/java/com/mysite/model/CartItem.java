package com.mysite.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class CartItem {
    private Long id;
    private Cart cart;
    private Long productId;
    private Long quantity;
    private BigDecimal price;
    private List<ProductConfiguration> chosenConfiguration;

    public CartItem(Long id, Cart cart, Long productId, Long quantity, BigDecimal price, List<ProductConfiguration> chosenConfiguration) {
        this.id = id;
        this.cart = cart;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.chosenConfiguration = chosenConfiguration;
    }

    public boolean isCartItemDataNull() {
        return Objects.isNull(this.getCart()) ||
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

    public List<ProductConfiguration> getChosenConfiguration() {
        return chosenConfiguration;
    }

    public void setChosenConfiguration(List<ProductConfiguration> chosenConfiguration) {
        this.chosenConfiguration = chosenConfiguration;
    }
}
