package com.mysite.modelpublic.dto;

import com.mysite.model.Cart;
import com.mysite.model.ProductConfiguration;

import java.math.BigDecimal;
import java.util.List;

public class CartItemDTO {
    private Long id;
    private Cart cart;
    private Long productId;
    private Long quantity;
    private BigDecimal price;
    private List<ProductConfiguration> chosenConfiguration;

    public CartItemDTO(Long id, Cart cart, Long productId, Long quantity, BigDecimal price, List<ProductConfiguration> chosenConfiguration) {
        this.id = id;
        this.cart = cart;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
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
