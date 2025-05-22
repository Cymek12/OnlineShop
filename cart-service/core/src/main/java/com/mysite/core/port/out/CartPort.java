package com.mysite.core.port.out;

import com.mysite.model.Cart;

import java.util.Optional;

public interface CartPort {

    Cart save(Cart cart);

    boolean existsById(Long id);

    Optional<Cart> findById(Long id);

    Optional<Cart> findByUserId(Long id);


}
