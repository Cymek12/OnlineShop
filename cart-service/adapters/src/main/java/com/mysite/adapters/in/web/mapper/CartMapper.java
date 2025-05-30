package com.mysite.adapters.in.web.mapper;

import com.mysite.adapters.out.persistance.entity.CartEntity;
import com.mysite.adapters.out.persistance.entity.CartItemConfigurationEntity;
import com.mysite.adapters.out.persistance.entity.CartItemEntity;
import com.mysite.model.Cart;
import com.mysite.model.CartItem;
import com.mysite.model.CartItemConfiguration;
import com.mysite.modelpublic.dto.cart.CartDTO;
import com.mysite.modelpublic.dto.cart.CartItemConfigurationDTO;
import com.mysite.modelpublic.dto.cart.CartItemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartMapper {

    Cart toDomain(CartEntity entity);

    CartItem toDomain(CartItemEntity entity);

    CartItemConfiguration toDomain(CartItemConfigurationEntity entity);

    CartEntity toEntity(Cart domain);

    CartItemEntity toEntity(CartItem domain);

    CartItemConfigurationEntity toEntity(CartItemConfiguration domain);

    CartDTO toDto(Cart domain);

    CartItemDTO toDto(CartItem domain);

    CartItemConfigurationDTO toDto(CartItemConfiguration domain);
}
