package com.mysite.adapters.out.persistance.repository;

import com.mysite.adapters.in.web.mapper.OrderMapper;
import com.mysite.adapters.out.persistance.entity.OrderEntity;
import com.mysite.core.port.out.OrderOperations;
import com.mysite.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class OrderRepository implements OrderOperations {
    private final SpringDataOrderRepository repository;
    private final OrderMapper orderMapper;

    @Override
    public Optional<Order> getOrderById(Long id) {
        Optional<OrderEntity> optionalOrderEntity = repository.findById(id);
        if (optionalOrderEntity.isPresent()) {
            return optionalOrderEntity.map(orderMapper::toDomain);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public void delete(Order order) {

    }
}
