package com.mysite.adapters.config;

import com.mysite.adapters.in.web.client.ProductServiceClient;
import com.mysite.core.exception.FallbackException;
import com.mysite.core.exception.ProductNotFoundException;
import com.mysite.model.PageContent;
import com.mysite.model.ProductDTO;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductFallbackFactory implements FallbackFactory<ProductServiceClient> {

    @Override
    public ProductServiceClient create(Throwable cause) {
        return new ProductServiceClient() {
            @Override
            public ProductDTO getProduct(String id) {
                log.warn("fallback reserve visit");
                throw new FallbackException("Product not found exception");
            }

            @Override
            public PageContent<ProductDTO> getAllProducts(int page, int size, String productType) {
                throw new FallbackException("Fallback get all products exception");
            }
        };
    }
}