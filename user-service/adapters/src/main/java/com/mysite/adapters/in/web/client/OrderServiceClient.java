package com.mysite.adapters.in.web.client;

import com.mysite.adapters.config.CartFallbackFactory;
import com.mysite.adapters.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        value = "orderService",
        url = "${spring.cloud.openfeign.client.config.orderService.url}"
//        configuration = FeignConfig.class,
//        fallbackFactory = CartFallbackFactory.class
)
public interface OrderServiceClient {

}
