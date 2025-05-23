package com.mysite.model;

import java.math.BigDecimal;

public class ProductConfigurationDTO {
    private Long id;
    private String name;
    private String value;
    private BigDecimal additionalPrice;

    public ProductConfigurationDTO(Long id, String name, String value, BigDecimal additionalPrice) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.additionalPrice = additionalPrice;
    }

    public ProductConfigurationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}