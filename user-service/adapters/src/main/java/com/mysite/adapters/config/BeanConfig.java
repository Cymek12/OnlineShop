package com.mysite.adapters.config;

import com.mysite.core.port.in.UserUseCase;
import com.mysite.core.port.out.ProductPort;
import com.mysite.core.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public UserUseCase userUseCase(ProductPort productPort) {
        return new UserService(productPort);
    }
}
