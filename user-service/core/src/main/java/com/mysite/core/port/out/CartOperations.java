package com.mysite.core.port.out;

import com.mysite.model.PageContent;
import com.mysite.modelpublic.dto.CartDTO;
import com.mysite.modelpublic.command.AddProductToCartCommand;

public interface CartOperations {
    CartDTO addProductToCart(AddProductToCartCommand addProductToCartCommand);

    PageContent<CartDTO> getCarts(int size, int page);
}
