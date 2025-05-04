package com.mysite.adapters.in.web.mapper;

import com.mysite.adapters.out.persistance.entity.CartEntity;
import com.mysite.model.Cart;
import com.mysite.modelpublic.dto.CartDTO;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = CartItemMapper.class)
public interface CartMapper {

    Cart toDomain(CartEntity entity);

    CartEntity toEntity(Cart domain);

    CartDTO toDto(Cart domain);

    Cart toDomainFromDto(CartDTO dto);
}

