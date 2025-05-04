package com.mysite.core.port.in;

import com.mysite.model.Cart;
import com.mysite.modelpublic.command.AddProductToCartCommand;

public interface CartUseCase {
    Cart addProductToCart(AddProductToCartCommand addProductToCartCommand);

    void deleteCartItem(Long cartId, Long cartItemId, Long quantity);

    Cart getCartById(Long id);
}
