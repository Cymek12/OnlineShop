package com.mysite.adapters.in.web.mapper;

import com.mysite.adapters.out.persistance.entity.CartItemEntity;
import com.mysite.model.CartItem;
import com.mysite.modelpublic.dto.CartItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ProductConfigurationMapper.class)
public interface CartItemMapper {

    @Mapping(target = "cart", ignore = true)
    CartItem toDomain(CartItemEntity entity);

    @Mapping(target = "cart", ignore = true)
    CartItemEntity toEntity(CartItem domain);

    @Mapping(target = "cart", ignore = true)
    CartItemDTO toDto(CartItem domain);

    @Mapping(target = "cart", ignore = true)
    CartItem toDomainFromDto(CartItemDTO dto);
}
