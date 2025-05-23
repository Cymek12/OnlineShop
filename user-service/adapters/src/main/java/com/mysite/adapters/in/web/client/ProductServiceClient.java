package com.mysite.adapters.in.web.client;

import com.mysite.core.port.out.ProductPort;
import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;
import com.mysite.model.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "app",
        url = "${spring.cloud.openfeign.client.config.postClient.url}"
)
public interface ProductServiceClient extends ProductPort {
    @GetMapping("/{id}")
    ProductDTO getProduct(@PathVariable("id") String id);

    @GetMapping
    PageContent<ProductDTO> getAllProducts(MyPageable pageable, @RequestParam(name = "productType", required = false) String productType);
}
