package com.mysite.modelpublic.dto;

import com.mysite.model.ProductType;

import java.math.BigDecimal;
import java.util.List;

public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private ProductType productType;
    private List<ProductConfigurationDTO> configurations;

    public ProductDTO(Long id, String name, BigDecimal price, ProductType productType, List<ProductConfigurationDTO> configurations) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.configurations = configurations;
    }

    public ProductDTO() {
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

    public List<ProductConfigurationDTO> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<ProductConfigurationDTO> configurations) {
        this.configurations = configurations;
    }
}
