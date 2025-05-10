package com.mysite.core.service;

import com.mysite.core.port.in.OrderUseCase;
import com.mysite.core.port.out.OrderPort;
import com.mysite.model.MyPageable;
import com.mysite.model.Order;
import com.mysite.model.PageContent;
import com.mysite.modelPublic.command.CreateOrderCommand;
import com.mysite.modelPublic.command.UpdateOrderCommand;

public class OrderService implements OrderUseCase {
    private final OrderPort orderPort;

    public OrderService(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @Override
    public Order createOrder(CreateOrderCommand request) {
        return null;
    }

    @Override
    public Order updateOrder(Long id, UpdateOrderCommand request) {
        return null;
    }

    @Override
    public Order getOrderById(Long id) {
        orderPort.getOrderById(id);
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PageContent<Order> getOrdersByUserId(MyPageable myPageable, Long userId) {
        return null;
    }
}
