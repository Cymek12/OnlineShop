package com.mysite.modelPublic.command;

import com.mysite.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private Long userId;
    private CustomerDTO customer;
    private AddressDTO address;
    private Long cartId;
    private BigDecimal orderPrice;
    private LocalDateTime orderDate;
    private OrderStatus status;
}
