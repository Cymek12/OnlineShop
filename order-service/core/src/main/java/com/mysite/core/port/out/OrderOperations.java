package com.mysite.core.port.out;

import com.mysite.model.Order;

import java.util.Optional;

public interface OrderOperations {
    Optional<Order> getOrderById(Long id);

    Order save(Order order);

    void delete(Order order);

}
