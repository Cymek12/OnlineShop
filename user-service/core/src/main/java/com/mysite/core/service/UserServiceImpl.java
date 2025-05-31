package com.mysite.core.service;

import com.mysite.core.port.in.UserService;
import com.mysite.core.port.out.CartOperations;
import com.mysite.core.port.out.ProductOperations;
import com.mysite.modelpublic.dto.CartDTO;
import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;
import com.mysite.modelpublic.dto.ProductDTO;
import com.mysite.modelpublic.command.AddProductToCartCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ProductOperations productOperations;
    private final CartOperations cartOperations;

    public ProductDTO getProduct(String id) {
        return productOperations.getProduct(id);
    }

    public PageContent<ProductDTO> getAllProducts(MyPageable myPageable, String productType){
        return productOperations.getAllProducts(myPageable.getPage(), myPageable.getSize(), productType);
    }

    public CartDTO addProductToCart(AddProductToCartCommand addProductToCartCommand) {
        return cartOperations.addProductToCart(addProductToCartCommand);
    }

    @Override
    public PageContent<CartDTO> getAllCarts(MyPageable myPageable) {
        return cartOperations.getCarts(myPageable);
    }
}
