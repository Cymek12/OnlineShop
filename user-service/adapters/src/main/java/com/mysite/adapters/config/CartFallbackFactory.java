package com.mysite.adapters.config;

import com.mysite.adapters.in.web.client.CartServiceClient;
import com.mysite.adapters.in.web.client.ProductServiceClient;
import com.mysite.core.exception.FallbackException;
import com.mysite.model.CartDTO;
import com.mysite.model.PageContent;
import com.mysite.model.ProductDTO;
import com.mysite.modelpublic.command.AddProductToCartCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CartFallbackFactory implements FallbackFactory<CartServiceClient> {
    @Override
    public CartServiceClient create(Throwable cause) {
        return new CartServiceClient() {

            @Override
            public CartDTO addProductToCart(AddProductToCartCommand addProductToCartCommand) {
                return null;
            }
        };
    }
}
