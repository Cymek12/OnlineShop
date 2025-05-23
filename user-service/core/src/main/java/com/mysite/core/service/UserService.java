package com.mysite.core.service;

import com.mysite.core.port.out.ProductPort;
import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;
import com.mysite.model.ProductDTO;

public class UserService {
    private final ProductPort productPort;

    public UserService(ProductPort productPort) {
        this.productPort = productPort;
    }

    public ProductDTO getProduct(String id) {
        return productPort.getProduct(id);
    }

    public PageContent<ProductDTO> getAllProducts(MyPageable myPageable, String productType){
        return productPort.getAllProducts(myPageable.getPage(), myPageable.getSize(), productType);
    }


}
