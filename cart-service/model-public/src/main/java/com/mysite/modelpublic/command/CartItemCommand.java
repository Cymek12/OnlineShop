package com.mysite.modelpublic.command;

import java.math.BigDecimal;
import java.util.List;

public class CartItemCommand {
    private Long productId;
    private Long cartId;
    private int quantity;
    private BigDecimal price;
    private List<ProductConfigurationCommand> chosenConfiguration;

    public CartItemCommand(Long productId, Long cartId, int quantity, BigDecimal price, List<ProductConfigurationCommand> chosenConfiguration) {
        this.productId = productId;
        this.cartId = cartId;
        this.quantity = quantity;
        this.price = price;
        this.chosenConfiguration = chosenConfiguration;
    }

    public CartItemCommand() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<ProductConfigurationCommand> getChosenConfiguration() {
        return chosenConfiguration;
    }

    public void setChosenConfiguration(List<ProductConfigurationCommand> chosenConfiguration) {
        this.chosenConfiguration = chosenConfiguration;
    }
}
