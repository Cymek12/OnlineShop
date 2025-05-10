package com.mysite.modelPublic.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CreateOrderCommand {
    private Long userId;
    private CustomerDTO customer;
    private AddressDTO address;
    private Long cartId;
    private BigDecimal orderPrice;
}
