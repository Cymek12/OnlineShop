package com.mysite.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private ProductType productType;
    private List<ProductConfiguration> configurations;

    public Product(Long id, String name, BigDecimal price, ProductType productType, List<ProductConfiguration> configurations) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.configurations = configurations;
    }

    public Product() {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public List<ProductConfiguration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<ProductConfiguration> configurations) {
        this.configurations = configurations;
    }

    public boolean isProductDataNull() {
        return Objects.isNull(this.getName()) ||
                Objects.isNull(this.getPrice()) ||
                Objects.isNull(this.getProductType());
    }

    public boolean isProductConfigurationListCorrect() {
        if (this.getProductType().equals(ProductType.ELECTRONICS)){
            return Objects.isNull(this.getConfigurations()) || this.getConfigurations().isEmpty();
        }
        else {
            return !Objects.isNull(this.getConfigurations()) && !this.getConfigurations().isEmpty();
        }
    }

    public void update(Product productNewData) {
        this.setName(productNewData.getName());
        this.setPrice(productNewData.getPrice());
        this.setProductType(productNewData.getProductType());
        this.setConfigurations(productNewData.getConfigurations());
    }
}
