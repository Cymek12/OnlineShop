package com.mysite.adapters.config;

import com.mysite.core.port.out.CartOperations;
import com.mysite.core.port.out.ProductOperations;
import com.mysite.core.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserServiceImpl userService(ProductOperations productPort, CartOperations cartPort) {
        return new UserServiceImpl(productPort, cartPort);
    }
}
