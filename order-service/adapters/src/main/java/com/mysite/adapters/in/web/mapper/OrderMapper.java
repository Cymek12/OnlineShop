package com.mysite.adapters.in.web.mapper;

import com.mysite.adapters.out.persistance.entity.AddressEntity;
import com.mysite.adapters.out.persistance.entity.CustomerEntity;
import com.mysite.adapters.out.persistance.entity.OrderEntity;
import com.mysite.model.Address;
import com.mysite.model.Customer;
import com.mysite.model.Order;
import com.mysite.modelPublic.command.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    // === DOMAIN ↔ ENTITY ===
    OrderEntity toEntity(Order domain);
    Order toDomain(OrderEntity entity);

    CustomerEntity toEntity(Customer domain);
    Customer toDomain(CustomerEntity entity);

    AddressEntity toEntity(Address domain);
    Address toDomain(AddressEntity entity);

    // === DOMAIN ↔ DTO ===
    OrderDTO toDto(Order domain);
    Order toDomain(CreateOrderCommand dto);

    Order toDomain(UpdateOrderCommand dto); // jeśli np. robisz partial update

    CustomerDTO toDto(Customer domain);
    Customer toDomain(CustomerDTO dto);

    AddressDTO toDto(Address domain);
    Address toDomain(AddressDTO dto);

    OrderSummaryDTO toSummaryResponse(Order domain);
}
