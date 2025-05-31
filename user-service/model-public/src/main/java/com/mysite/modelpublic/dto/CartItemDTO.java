package com.mysite.modelpublic.dto;

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
public class CartItemDTO {
    private Long id;
    private Long productId;
    private Long quantity;
    private BigDecimal price;
    private Long cartId;
    private List<CartItemConfigurationDTO> chosenConfiguration;
}