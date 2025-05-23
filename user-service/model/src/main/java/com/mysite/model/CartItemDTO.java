package com.mysite.model;

import java.math.BigDecimal;
import java.util.Set;

public class CartItemDTO {
    private Long id;
    private Long productId;
    private Long quantity;
    private BigDecimal price;
    private Long cartId;
    private Set<CartItemConfigurationDTO> chosenConfiguration;

    public CartItemDTO(Long id, Long productId, Long quantity, BigDecimal price, Long cartId, Set<CartItemConfigurationDTO> chosenConfiguration) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.cartId = cartId;
        this.chosenConfiguration = chosenConfiguration;
    }

    public CartItemDTO() {
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

    public Set<CartItemConfigurationDTO> getChosenConfiguration() {
        return chosenConfiguration;
    }

    public void setChosenConfiguration(Set<CartItemConfigurationDTO> chosenConfiguration) {
        this.chosenConfiguration = chosenConfiguration;
    }
}