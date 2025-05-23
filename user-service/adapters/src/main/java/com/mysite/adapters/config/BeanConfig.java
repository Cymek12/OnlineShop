package com.mysite.adapters.config;

import com.mysite.core.port.out.CartPort;
import com.mysite.core.port.out.ProductPort;
import com.mysite.core.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserService userService(ProductPort productPort, CartPort cartPort) {
        return new UserService(productPort, cartPort);
    }
}
