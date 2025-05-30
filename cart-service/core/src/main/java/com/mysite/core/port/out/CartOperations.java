package com.mysite.core.port.out;

import com.mysite.model.Cart;
import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;

import java.util.Optional;

public interface CartOperations {

    Cart save(Cart cart);

    Optional<Cart> findById(Long id);

    Optional<Cart> findByUserId(Long id);

    void delete(Cart cart);

    PageContent<Cart> findAll(MyPageable myPageable);
}
