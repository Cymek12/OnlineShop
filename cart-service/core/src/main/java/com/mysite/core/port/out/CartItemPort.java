package com.mysite.core.port.out;

import com.mysite.model.CartItem;

public interface CartItemPort {
    void delete(CartItem cartItem);

    CartItem save(CartItem cartItem);
}
