package com.mysite.core.port.in;

import com.mysite.model.ProductDTO;

public interface UserUseCase {
    ProductDTO getProduct(String id);
}
