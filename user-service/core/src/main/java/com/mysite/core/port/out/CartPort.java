package com.mysite.core.port.out;

import com.mysite.model.CartDTO;
import com.mysite.modelpublic.command.AddProductToCartCommand;

public interface CartPort {
    CartDTO addProductToCart(AddProductToCartCommand addProductToCartCommand);
}
