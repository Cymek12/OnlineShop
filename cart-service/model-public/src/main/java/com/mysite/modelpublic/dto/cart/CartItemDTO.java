package com.mysite.modelpublic.dto.cart;

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
    private List<CartItemConfigurationDTO> chosenConfiguration;
}
