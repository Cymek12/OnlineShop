package com.mysite.adapters.config;

import com.mysite.core.port.in.ProductUseCase;
import com.mysite.core.port.out.ProductPort;
import com.mysite.core.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ProductUseCase productUseCase(ProductPort productPort) {
        return new ProductService(productPort);
    }
}
