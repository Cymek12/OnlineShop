package com.mysite.modelpublic.command;

import com.mysite.model.ProductConfiguration;

import java.math.BigDecimal;
import java.util.List;

public class AddProductToCartCommand {
    private Long userId;
    private Long productId;
    private Long quantity;
    private BigDecimal price;
    private List<ProductConfiguration> chosenConfiguration;

    public AddProductToCartCommand(Long userId, Long productId, Long quantity, BigDecimal price, List<ProductConfiguration> chosenConfiguration) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.chosenConfiguration = chosenConfiguration;
    }

    public AddProductToCartCommand() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
