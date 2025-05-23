package com.mysite.modelpublic.command;

import java.util.List;

public class AddProductToCartCommand {
    private Long userId;
    private Long productId;
    private Long quantity;
    private List<Long> configurationIds;

    public AddProductToCartCommand(Long userId, Long productId, Long quantity, List<Long> configurationIds) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.configurationIds = configurationIds;
    }

    public AddProductToCartCommand() {
    }

    public List<Long> getConfigurationIds() {
        return configurationIds;
    }

    public void setConfigurationIds(List<Long> configurationIds) {
        this.configurationIds = configurationIds;
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


}