package com.mysite.adapters.in.web.mapper;

import com.mysite.adapters.out.persistance.entity.CartEntity;
import com.mysite.adapters.out.persistance.entity.CartItemConfigurationEntity;
import com.mysite.adapters.out.persistance.entity.CartItemEntity;
import com.mysite.model.Cart;
import com.mysite.model.CartItem;
import com.mysite.model.CartItemConfiguration;
import com.mysite.modelpublic.dto.CartDTO;
import com.mysite.modelpublic.dto.CartItemConfigurationDTO;
import com.mysite.modelpublic.dto.CartItemDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CartMapper {

    public Cart toDomain(CartEntity entity) {
        Cart domain = new Cart();
        domain.setId(entity.getId());
        domain.setCreatedAt(entity.getCreatedAt());
        domain.setUpdatedAt(entity.getUpdatedAt());
        domain.setUserId(entity.getUserId());
        domain.setAddedProducts(entity.getAddedProducts().stream().map(this::toDomain).collect(Collectors.toSet()));
        return domain;
    }

    public CartItem toDomain(CartItemEntity entity) {
        CartItem domain = new CartItem();
        domain.setId(entity.getId());
        domain.setQuantity(entity.getQuantity());
        domain.setPrice(entity.getPrice());
        domain.setProductId(entity.getProductId());
        domain.setCartId(entity.getCart().getId());
        domain.setChosenConfiguration(entity.getChosenConfiguration().stream().map(this::toDomain).collect(Collectors.toSet()));
        return domain;
    }

    public CartItemConfiguration toDomain(CartItemConfigurationEntity entity) {
        CartItemConfiguration domain = new CartItemConfiguration();
        domain.setId(entity.getId());
        domain.setValue(entity.getValue());
        domain.setAdditionalPrice(entity.getAdditionalPrice());
        domain.setConfigurationType(entity.getConfigurationType());
        domain.setCartItemId(entity.getCartItem().getId());
        return domain;
    }

    public CartEntity toEntity(Cart domain) {
        CartEntity entity = new CartEntity();
        entity.setId(domain.getId());
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setUpdatedAt(domain.getUpdatedAt());
        entity.setUserId(domain.getUserId());
        entity.setAddedProducts(domain.getAddedProducts().stream().map(this::toEntity).collect(Collectors.toSet()));
        return entity;
    }

    public CartItemEntity toEntity(CartItem domain) {
        CartItemEntity entity = new CartItemEntity();
        CartEntity cartEntity = new CartEntity();
        cartEntity.setId(domain.getCartId());

        entity.setId(domain.getId());
        entity.setPrice(domain.getPrice());
        entity.setQuantity(domain.getQuantity());
        entity.setCart(cartEntity);
        entity.setChosenConfiguration(domain.getChosenConfiguration().stream().map(this::toEntity).collect(Collectors.toSet()));
        return entity;
    }

    public CartItemConfigurationEntity toEntity(CartItemConfiguration domain) {
        CartItemConfigurationEntity entity = new CartItemConfigurationEntity();
        CartItemEntity cartItemEntity = new CartItemEntity();
        cartItemEntity.setId(domain.getCartItemId());

        entity.setId(domain.getId());
        entity.setAdditionalPrice(domain.getAdditionalPrice());
        entity.setValue(domain.getValue());
        entity.setConfigurationType(domain.getConfigurationType());
        entity.setCartItem(cartItemEntity);
        return entity;
    }

    public CartDTO toDto(Cart domain) {
        CartDTO dto = new CartDTO();
        dto.setId(domain.getId());
        dto.setCreatedAt(domain.getCreatedAt());
        dto.setUpdatedAt(domain.getUpdatedAt());
        dto.setUserId(domain.getUserId());
        dto.setAddedProducts(domain.getAddedProducts().stream().map(this::toDto).collect(Collectors.toSet()));
        return dto;
    }

    public CartItemDTO toDto(CartItem domain) {
        CartItemDTO dto = new CartItemDTO();
        dto.setId(domain.getId());
        dto.setPrice(domain.getPrice());
        dto.setQuantity(domain.getQuantity());
        dto.setProductId(domain.getProductId());
        dto.setCartId(domain.getCartId());
        dto.setChosenConfiguration(domain.getChosenConfiguration().stream().map(this::toDto).collect(Collectors.toSet()));
        return dto;
    }

    public CartItemConfigurationDTO toDto(CartItemConfiguration domain) {
        CartItemConfigurationDTO dto = new CartItemConfigurationDTO();
        dto.setId(domain.getId());
        dto.setValue(domain.getValue());
        dto.setAdditionalPrice(domain.getAdditionalPrice());
        dto.setConfigurationType(domain.getConfigurationType());
        dto.setCartItemId(domain.getCartItemId());
        return dto;
    }
}
