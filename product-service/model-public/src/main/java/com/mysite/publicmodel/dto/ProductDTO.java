package com.mysite.publicmodel.dto;

import com.mysite.model.ProductType;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private ProductType productType;
    private List<ProductConfigurationDTO> configurations;

}
