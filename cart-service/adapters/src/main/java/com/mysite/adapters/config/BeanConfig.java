package com.mysite.adapters.config;

import com.mysite.core.port.in.CartService;
import com.mysite.core.port.out.CartOperations;
import com.mysite.core.port.out.ProductOperations;
import com.mysite.core.service.CartServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class BeanConfig {

    @Bean
    public CartService cartUseCase(CartOperations cartOperations, ProductOperations productOperations) {
        return new CartServiceImpl(cartOperations, productOperations, Clock.systemDefaultZone());
    }
}
