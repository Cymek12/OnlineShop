package com.mysite.core.port.out;

import com.mysite.modelpublic.dto.product.ProductDTO;

public interface ProductOperations {
    ProductDTO getProduct(String id);
}