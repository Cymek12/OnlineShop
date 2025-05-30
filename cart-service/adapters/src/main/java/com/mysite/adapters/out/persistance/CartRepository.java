package com.mysite.adapters.out.persistance;

import com.mysite.adapters.in.web.mapper.CartMapper;
import com.mysite.adapters.out.persistance.entity.CartEntity;
import com.mysite.adapters.out.persistance.entity.CartItemConfigurationEntity;
import com.mysite.adapters.out.persistance.entity.CartItemEntity;
import com.mysite.core.port.out.CartOperations;
import com.mysite.model.Cart;
import com.mysite.model.MyPageable;
import com.mysite.model.PageContent;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CartRepository implements CartOperations {
    private final SpringDataCartRepository repository;
    private final CartMapper cartMapper;

    @Override
    @Transactional
    public Cart save(Cart cart) {
        CartEntity entity = cartMapper.toEntity(cart);
        for (CartItemEntity addedProduct : entity.getAddedProducts()) {
            addedProduct.setCart(entity);
            for (CartItemConfigurationEntity cartItemConfigurationEntity : addedProduct.getChosenConfiguration()) {
                cartItemConfigurationEntity.setCartItem(addedProduct);
            }
        }
        CartEntity saved = repository.save(entity);
        return cartMapper.toDomain(saved);
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return repository.findById(id).map(cartMapper::toDomain);
    }

    @Override
    public Optional<Cart> findByUserId(Long id) {
        return repository.findByUserId(id).map(cartMapper::toDomain);
    }

    @Override
    public void delete(Cart cart) {
        repository.delete(cartMapper.toEntity(cart));
    }

    @Override
    public PageContent<Cart> findAll(MyPageable myPageable) {
        Pageable pageable = PageRequest.of(myPageable.getPage(), myPageable.getSize());
        Page<CartEntity> pageContent = repository.findAll(pageable);
        List<Cart> list = pageContent.getContent().stream().map(cartMapper::toDomain).collect(Collectors.toList());
        return new PageContent<>(
                pageContent.getTotalElements(),
                pageContent.getNumber(),
                pageContent.getTotalPages(),
                list);
    }
}
