package com.mysite.adapters.out.persistance.entity;

import com.mysite.model.ProductType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    @OneToMany(mappedBy = "product", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<ProductConfigurationEntity> configurations;

    public ProductEntity(Long id, String name, BigDecimal price, ProductType productType, List<ProductConfigurationEntity> configurations) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
        this.configurations = configurations;
    }

    public ProductEntity() {
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

    public List<ProductConfigurationEntity> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<ProductConfigurationEntity> configurations) {
        this.configurations = configurations;
    }
}
