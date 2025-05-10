package com.mysite.adapters.config;

import com.mysite.core.port.in.OrderUseCase;
import com.mysite.core.port.out.OrderPort;
import com.mysite.core.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public OrderUseCase orderUseCase(OrderPort orderPort) {
        return new OrderService(orderPort);
    }
}
