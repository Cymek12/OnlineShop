package com.mysite.adapters.config;

import com.mysite.adapters.in.web.client.CartServiceClient;
import com.mysite.core.exception.FallbackException;
import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;
import com.mysite.modelpublic.dto.CartDTO;
import com.mysite.modelpublic.command.AddProductToCartCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CartFallbackFactory implements FallbackFactory<CartServiceClient> {
    @Override
    public CartServiceClient create(Throwable cause) {
        return new CartServiceClient() {

            @Override
            public CartDTO addProductToCart(AddProductToCartCommand addProductToCartCommand) {
                throw new FallbackException("Fallback add product to cart exception");
            }

            @Override
            public PageContent<CartDTO> getCarts(MyPageable myPageable) {
                throw new FallbackException("Fallback get all carts exception");
            }
        };
    }
}
