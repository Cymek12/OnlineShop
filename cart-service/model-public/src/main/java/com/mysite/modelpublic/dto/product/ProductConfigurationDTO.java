package com.mysite.modelpublic.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductConfigurationDTO {
    private Long id;
    private String name;
    private String value;
    private BigDecimal additionalPrice;
}
