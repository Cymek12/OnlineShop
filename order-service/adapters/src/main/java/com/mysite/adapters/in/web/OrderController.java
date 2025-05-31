package com.mysite.adapters.in.web;

import com.mysite.adapters.in.web.mapper.OrderMapper;
import com.mysite.core.port.in.OrderService;
import com.mysite.model.MyPageable;
import com.mysite.model.Order;
import com.mysite.model.PageContent;
import com.mysite.modelPublic.command.CreateOrderCommand;
import com.mysite.modelPublic.command.OrderDTO;
import com.mysite.modelPublic.command.UpdateOrderCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @PostMapping
    public OrderDTO createOrder(@RequestBody CreateOrderCommand request) {
        Order order = orderService.createOrder(request);
        return orderMapper.toDto(order);
    }

    @PutMapping("/{id}")
    public OrderDTO updateOrder(@PathVariable Long id, @RequestBody UpdateOrderCommand request){
        Order order = orderService.updateOrder(id, request);
        return orderMapper.toDto(order);
    }

    @GetMapping("/{id}")
    public OrderDTO getOrder(@PathVariable Long id){
        Order order = orderService.getOrderById(id);
        return orderMapper.toDto(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.delete(id);
    }

    @GetMapping("/user/{userId}")
    public PageContent<OrderDTO> getOrdersByUserId(Pageable pageable, @PathVariable Long userId){
        MyPageable myPageable = new MyPageable(pageable.getPageSize(), pageable.getPageNumber());
        PageContent<Order> ordersPageContent = orderService.getOrdersByUserId(myPageable, userId);
        List<OrderDTO> list = ordersPageContent.getContent().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
        return new PageContent<>(ordersPageContent.getTotalElements(),
                ordersPageContent.getCurrentPage(),
                ordersPageContent.getTotalPageNumber(),
                list);
    }

    @PostMapping(value = "/invoice", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] generateInvoice() {
        return orderService.generateInvoice();
    }
}
