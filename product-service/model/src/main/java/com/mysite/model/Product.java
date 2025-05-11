package com.mysite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private ProductType productType;
    private List<ProductConfiguration> configurations;


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
