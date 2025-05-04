package com.mysite.adapters.out.persistance;

import com.mysite.adapters.in.web.mapper.CartItemMapper;
import com.mysite.adapters.out.persistance.entity.CartItemEntity;
import com.mysite.core.port.out.CartItemPort;
import com.mysite.model.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CartItemRepository implements CartItemPort {
    private final SpringDataCartItemRepository repository;
    private final CartItemMapper cartItemMapper;

    @Override
    public void delete(CartItem cartItem) {
        CartItemEntity entity = cartItemMapper.toEntity(cartItem);
        repository.delete(entity);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        CartItemEntity entity = cartItemMapper.toEntity(cartItem);
        CartItemEntity saved = repository.save(entity);
        return cartItemMapper.toDomain(saved);
    }
}
