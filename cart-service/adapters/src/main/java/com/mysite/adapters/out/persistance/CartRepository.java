package com.mysite.adapters.out.persistance;

import com.mysite.adapters.in.web.mapper.CartMapper;
import com.mysite.adapters.out.persistance.entity.CartEntity;
import com.mysite.core.port.out.CartPort;
import com.mysite.model.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@RequiredArgsConstructor
@Component
public class CartRepository implements CartPort {
    private final SpringDataCartRepository repository;
    private final CartMapper cartMapper;

    @Override
    @Transactional
    public Cart save(Cart cart) {
        CartEntity entity = cartMapper.toEntity(cart);
        CartEntity saved = repository.save(entity);
        return cartMapper.toDomain(saved);
    }

    @Override
    @Transactional
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    @Override
    @Transactional
    public Optional<Cart> findById(Long id) {
        Optional<CartEntity> optionalCartEntity = repository.findById(id);
        if(optionalCartEntity.isPresent()){
            return optionalCartEntity.map(cartMapper::toDomain);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Cart> findByUserId(Long id) {
        Optional<CartEntity> optionalCartEntity = repository.findFullByUserId(id);
        if(optionalCartEntity.isPresent()){
            return optionalCartEntity.map(cartMapper::toDomain);
        }
        return Optional.empty();
    }
}
