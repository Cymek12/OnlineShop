package com.mysite.adapters.in.web.client;

import com.mysite.core.port.out.ProductOperations;
import com.mysite.modelpublic.dto.product.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        value = "app",
        url = "${spring.cloud.openfeign.client.config.postClient.url}"
)
public interface ProductServiceClient extends ProductOperations {
    @GetMapping("/{id}")
    ProductDTO getProduct(@PathVariable("id") String id);
}