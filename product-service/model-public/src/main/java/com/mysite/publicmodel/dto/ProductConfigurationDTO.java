package com.mysite.publicmodel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductConfigurationDTO {
    private Long id;
    private String name;
    private String value;
    private BigDecimal additionalPrice;
}