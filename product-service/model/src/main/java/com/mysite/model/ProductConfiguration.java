package com.mysite.model;

import java.math.BigDecimal;
import java.util.Objects;

public class ProductConfiguration {
    private Long id;
    private String name;
    private String value;
    private BigDecimal additionalPrice;
    private Product product;

    public ProductConfiguration(Long id, String name, String value, BigDecimal additionalPrice, Product product) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.additionalPrice = additionalPrice;
        this.product = product;
    }

    public boolean isProductDataNull() {
        return Objects.isNull(this.getName()) ||
                Objects.isNull(this.getValue()) ||
                Objects.isNull(this.getAdditionalPrice());
    }

    public ProductConfiguration() {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
