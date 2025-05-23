package com.mysite.core.service;

import com.mysite.core.port.out.CartPort;
import com.mysite.core.port.out.ProductPort;
import com.mysite.model.CartDTO;
import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;
import com.mysite.model.ProductDTO;
import com.mysite.modelpublic.command.AddProductToCartCommand;

public class UserService {
    private final ProductPort productPort;
    private final CartPort cartPort;

    public UserService(ProductPort productPort, CartPort cartPort) {
        this.productPort = productPort;
        this.cartPort = cartPort;
    }

    public ProductDTO getProduct(String id) {
        return productPort.getProduct(id);
    }

    public PageContent<ProductDTO> getAllProducts(MyPageable myPageable, String productType){
        return productPort.getAllProducts(myPageable.getPage(), myPageable.getSize(), productType);
    }

    public CartDTO addProductToCart(AddProductToCartCommand addProductToCartCommand) {
        return cartPort.addProductToCart(addProductToCartCommand);
    }
}
