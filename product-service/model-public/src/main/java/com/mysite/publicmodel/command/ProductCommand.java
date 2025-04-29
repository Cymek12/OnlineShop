package com.mysite.publicmodel.command;

import com.mysite.model.ProductType;

import java.math.BigDecimal;
import java.util.List;

public class ProductCommand {
    private String name;
    private BigDecimal price;
    private ProductType productType;
    private List<ProductConfigurationCommand> configurations;

    public ProductCommand() {
    }

    public ProductCommand(String name, BigDecimal price, ProductType productType, List<ProductConfigurationCommand> configurations) {
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.configurations = configurations;
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

    public List<ProductConfigurationCommand> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<ProductConfigurationCommand> configurations) {
        this.configurations = configurations;
    }
}
