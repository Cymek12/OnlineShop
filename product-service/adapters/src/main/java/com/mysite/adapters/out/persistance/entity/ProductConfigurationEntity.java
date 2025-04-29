package com.mysite.adapters.out.persistance.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product_configuration")
public class ProductConfigurationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String value;
    private BigDecimal additionalPrice;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    public ProductConfigurationEntity(Long id, String name, String value, BigDecimal additionalPrice, ProductEntity product) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.additionalPrice = additionalPrice;
        this.product = product;
    }

    public ProductConfigurationEntity() {
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

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
