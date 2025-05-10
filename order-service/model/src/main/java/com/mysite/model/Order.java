package com.mysite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Order {
    private Long id;
    private Customer customerDetails;
    private Long cartId;
    private Address deliveryAddress;
    private BigDecimal orderPrice;
    private OrderStatus status;
}
