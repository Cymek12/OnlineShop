package com.mysite.modelpublic.dto;

import java.math.BigDecimal;

public class ProductConfigurationDTO {
    private Long id;
    private String configurationType;
    private String value;
    private BigDecimal additionalPrice;
    private Long productId;

    public ProductConfigurationDTO() {
    }

    public ProductConfigurationDTO(Long id, String configurationType, String value, BigDecimal additionalPrice, Long productId) {
        this.id = id;
        this.configurationType = configurationType;
        this.value = value;
        this.additionalPrice = additionalPrice;
        this.productId = productId;
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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
