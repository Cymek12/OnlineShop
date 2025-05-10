package com.mysite.core.port.in;

import com.mysite.model.MyPageable;
import com.mysite.model.Order;
import com.mysite.model.PageContent;
import com.mysite.modelPublic.command.CreateOrderCommand;
import com.mysite.modelPublic.command.UpdateOrderCommand;

public interface OrderUseCase {
    Order createOrder(CreateOrderCommand request);

    Order updateOrder(Long id, UpdateOrderCommand request);

    Order getOrderById(Long id);

    void delete(Long id);

    PageContent<Order> getOrdersByUserId(MyPageable myPageable, Long userId);
}
