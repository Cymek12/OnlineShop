package com.mysite.core.port.in;

import com.mysite.modelpublic.dto.CartDTO;
import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;
import com.mysite.modelpublic.dto.ProductDTO;
import com.mysite.modelpublic.command.AddProductToCartCommand;

public interface UserService {
    ProductDTO getProduct(String id);

    PageContent<ProductDTO> getAllProducts(MyPageable myPageable, String productType);

    CartDTO addProductToCart(AddProductToCartCommand addProductToCartCommand);

    PageContent<CartDTO> getAllCarts(MyPageable myPageable);
}
