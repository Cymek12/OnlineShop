package com.mysite.modelpublic.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartItemConfigurationDTO {
    private Long id;
    private String configurationType;
    private String value;
    private BigDecimal additionalPrice;
}
