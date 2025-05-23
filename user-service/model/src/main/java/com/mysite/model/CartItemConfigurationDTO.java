package com.mysite.model;

import java.math.BigDecimal;

public class CartItemConfigurationDTO {
    private Long id;
    private String configurationType;
    private String value;
    private BigDecimal additionalPrice;
    private Long cartItemId;

    public CartItemConfigurationDTO() {
    }

    public CartItemConfigurationDTO(Long id, String configurationType, String value, BigDecimal additionalPrice, Long cartItemId) {
        this.id = id;
        this.configurationType = configurationType;
        this.value = value;
        this.additionalPrice = additionalPrice;
        this.cartItemId = cartItemId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConfigurationType() {
        return configurationType;
    }

    public void setConfigurationType(String configurationType) {
        this.configurationType = configurationType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BigDecimal getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(BigDecimal additionalPrice) {
        this.additionalPrice = additionalPrice;
    }

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }
}