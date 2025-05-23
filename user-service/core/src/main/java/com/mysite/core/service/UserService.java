package com.mysite.core.service;

import com.mysite.core.port.out.ProductPort;
import com.mysite.model.ProductDTO;

public class UserService {
    private final ProductPort productPort;

    public UserService(ProductPort productPort) {
        this.productPort = productPort;
    }

    public ProductDTO getProduct(String id) {
        return productPort.getProduct(id);
    }
}
