package com.mysite.adapters.in.web.client;

import com.mysite.adapters.config.FeignConfig;
import com.mysite.adapters.config.ProductFallbackFactory;
import com.mysite.core.port.out.ProductPort;
import com.mysite.model.PageContent;
import com.mysite.model.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "productService",
        url = "${spring.cloud.openfeign.client.config.productService.url}",
        configuration = FeignConfig.class,
        fallbackFactory = ProductFallbackFactory.class
)
public interface ProductServiceClient extends ProductPort {
    @GetMapping("/products/{id}")
    ProductDTO getProduct(@PathVariable("id") String id);

    @GetMapping("/products")
    PageContent<ProductDTO> getAllProducts(@RequestParam("page") int page,
                                           @RequestParam("size") int size,
                                           @RequestParam(name = "productType", required = false) String productType);
}
