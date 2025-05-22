package com.mysite.adapters.in.web;

import com.mysite.adapters.in.web.mapper.OrderMapper;
import com.mysite.core.port.in.OrderUseCase;
import com.mysite.model.MyPageable;
import com.mysite.model.Order;
import com.mysite.model.PageContent;
import com.mysite.modelPublic.command.CreateOrderCommand;
import com.mysite.modelPublic.command.OrderDTO;
import com.mysite.modelPublic.command.UpdateOrderCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderUseCase orderUseCase;
    private final OrderMapper orderMapper;

    @PostMapping
    public OrderDTO createOrder(@RequestBody CreateOrderCommand request) {
        Order order = orderUseCase.createOrder(request);
        return orderMapper.toDto(order);
    }

    @PutMapping("/{id}")
    public OrderDTO updateOrder(@PathVariable Long id, @RequestBody UpdateOrderCommand request){
        Order order = orderUseCase.updateOrder(id, request);
        return orderMapper.toDto(order);
    }

    @GetMapping("/{id}")
    public OrderDTO getOrder(@PathVariable Long id){
        Order order = orderUseCase.getOrderById(id);
        return orderMapper.toDto(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderUseCase.delete(id);
    }

    @GetMapping("/user/{userId}")
    public PageContent<OrderDTO> getOrdersByUserId(Pageable pageable, @PathVariable Long userId){
        MyPageable myPageable = new MyPageable(pageable.getPageSize(), pageable.getPageNumber());
        PageContent<Order> ordersPageContent = orderUseCase.getOrdersByUserId(myPageable, userId);
        List<OrderDTO> list = ordersPageContent.getContent().stream()
                .map(orderMapper::toDto)
                .toList();
        return new PageContent<>(ordersPageContent.getTotalElements(),
                ordersPageContent.getCurrentPage(),
                ordersPageContent.getTotalPageNumber(),
                list);
    }

    @PostMapping("/invoice")
    public byte[] generateInvoice() {
        return orderUseCase.generateInvoice();
    }
}
