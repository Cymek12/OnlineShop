package com.mysite.adapters.config;

import com.mysite.core.port.in.OrderService;
import com.mysite.core.port.out.InvoiceGeneratorPort;
import com.mysite.core.port.out.OrderOperations;
import com.mysite.core.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public OrderService orderUseCase(OrderOperations orderOperations, InvoiceGeneratorPort invoiceGeneratorPort) {
        return new OrderServiceImpl(orderOperations, invoiceGeneratorPort);
    }
}
