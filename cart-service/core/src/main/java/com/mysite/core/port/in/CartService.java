package com.mysite.core.port.in;

import com.mysite.model.Cart;
import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;
import com.mysite.modelpublic.command.AddProductToCartCommand;

public interface CartService {
    Cart addProductToCart(AddProductToCartCommand addProductToCartCommand);

    Cart deleteCartItem(Long cartId, Long cartItemId, Long quantity);

    Cart getCartById(Long id);

    PageContent<Cart> getCarts(MyPageable myPageable);

    void deleteCart(Long id);
}
