package com.mysite.core.port.out;

import com.mysite.model.PageContent;
import com.mysite.modelpublic.dto.ProductDTO;

public interface ProductOperations {
    ProductDTO getProduct(String id);

    PageContent<ProductDTO> getAllProducts(int size, int page, String productType);
}
