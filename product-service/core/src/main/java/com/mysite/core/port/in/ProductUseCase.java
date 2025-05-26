package com.mysite.core.port.in;

import com.mysite.model.PageContent;
import com.mysite.model.MyPageable;
import com.mysite.model.Product;

public interface ProductUseCase {
    Product addProduct(Product product);

    Product getProductById(Long id);

    PageContent<Product> getAllProducts(MyPageable myPageable, String productType);

    Product updateProduct(Long idProductToUpdate, Product productNewData);

    void deleteProduct(Long id);
}
