package com.mysite.adapters.in.web.client;

import com.mysite.adapters.config.CartFallbackFactory;
import com.mysite.adapters.config.FeignConfig;
import com.mysite.core.port.out.CartPort;
import com.mysite.model.CartDTO;
import com.mysite.modelpublic.command.AddProductToCartCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "cartService",
        url = "${spring.cloud.openfeign.client.config.cartService.url}",
        configuration = FeignConfig.class,
        fallbackFactory = CartFallbackFactory.class
)
public interface CartServiceClient extends CartPort {
    @PostMapping("/carts")
    CartDTO addProductToCart(@RequestBody AddProductToCartCommand addProductToCartCommand);

}
