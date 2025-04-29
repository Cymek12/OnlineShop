package com.mysite.core.port.out;

import com.mysite.model.PageContent;
import com.mysite.model.MyPageable;
import com.mysite.model.Product;
import com.mysite.model.ProductType;

import java.util.Optional;

public interface ProductPort {
    Product save(Product product);

    Optional<Product> findById(Long id);

    boolean existsByName(String name);

    void delete(Product product);

    PageContent<Product> findAll(MyPageable myPageable);

    PageContent<Product> findByProductType(ProductType productType, MyPageable myPageable);
}
