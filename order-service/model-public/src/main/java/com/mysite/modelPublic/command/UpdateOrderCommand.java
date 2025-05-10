package com.mysite.modelPublic.command;

import com.mysite.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UpdateOrderCommand {
    private OrderStatus status;
    private AddressDTO address;
}
