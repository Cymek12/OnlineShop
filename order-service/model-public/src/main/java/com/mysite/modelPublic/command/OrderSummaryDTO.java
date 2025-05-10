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
public class OrderSummaryDTO {
    private Long id;
    private BigDecimal orderPrice;
    private OrderStatus status;
    private LocalDateTime orderDate;
}
