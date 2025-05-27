package com.mysite.adapters.config;

import com.mysite.core.port.in.ProductService;
import com.mysite.core.port.out.ProductOperations;
import com.mysite.core.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ProductService productService(ProductOperations productPort) {
        return new ProductServiceImpl(productPort);
    }
}
