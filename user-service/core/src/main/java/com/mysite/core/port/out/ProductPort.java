package com.mysite.core.port.out;

import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;
import com.mysite.model.ProductDTO;

public interface ProductPort {
    ProductDTO getProduct(String id);

    PageContent<ProductDTO> getAllProducts(MyPageable pageable, String productType);
}
