package com.mysite.adapters.config;

import com.mysite.core.port.in.CartUseCase;
import com.mysite.core.port.out.CartPort;
import com.mysite.core.port.out.ProductPort;
import com.mysite.core.service.CartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CartUseCase cartUseCase(CartPort cartPort, ProductPort productPort) {
        return new CartService(cartPort, productPort);
    }
}
