package com.mysite.core.port.out;

import com.mysite.modelpublic.dto.ProductDTO;

public interface ProductPort {
    ProductDTO getProduct(String id);
}