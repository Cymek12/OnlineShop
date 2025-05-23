package com.mysite.core.service;

import com.mysite.core.port.in.UserUseCase;
import com.mysite.core.port.out.ProductPort;
import com.mysite.model.ProductDTO;

public class UserService implements UserUseCase {
    private final ProductPort productPort;

    public UserService(ProductPort productPort) {
        this.productPort = productPort;
    }

    @Override
    public ProductDTO getProduct(String id) {
        return productPort.getProduct(id);
    }
}
