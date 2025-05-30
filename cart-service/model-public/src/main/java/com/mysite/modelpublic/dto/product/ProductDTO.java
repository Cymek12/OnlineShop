package com.mysite.modelpublic.dto.product;

import com.mysite.model.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private ProductType productType;
    private List<ProductConfigurationDTO> configurations;
}
