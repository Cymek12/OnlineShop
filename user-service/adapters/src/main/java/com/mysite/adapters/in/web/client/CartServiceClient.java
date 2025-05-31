package com.mysite.adapters.in.web.client;

import com.mysite.adapters.config.CartFallbackFactory;
import com.mysite.adapters.config.FeignConfig;
import com.mysite.core.port.out.CartOperations;
import com.mysite.model.PageContent;
import com.mysite.modelpublic.dto.CartDTO;
import com.mysite.modelpublic.command.AddProductToCartCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "cartService",
        url = "${spring.cloud.openfeign.client.config.cartService.url}",
        configuration = FeignConfig.class,
        fallbackFactory = CartFallbackFactory.class
)
public interface CartServiceClient extends CartOperations {
    @PostMapping("/carts")
    CartDTO addProductToCart(@RequestBody AddProductToCartCommand addProductToCartCommand);

    @GetMapping("/carts")
    PageContent<CartDTO> getCarts(@RequestParam("page") int page,
                                  @RequestParam("size") int size);
}
