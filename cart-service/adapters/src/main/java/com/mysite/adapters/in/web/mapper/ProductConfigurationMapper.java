package com.mysite.adapters.in.web.mapper;

import com.mysite.adapters.out.persistance.entity.ProductConfigurationEntity;
import com.mysite.model.ProductConfiguration;
import com.mysite.modelpublic.dto.ProductConfigurationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductConfigurationMapper {

    @Mapping(source = "cartItemId", target = "productId")
    ProductConfiguration toDomain(ProductConfigurationEntity entity);

    @Mapping(source = "productId", target = "cartItemId")
    ProductConfigurationEntity toEntity(ProductConfiguration domain);

    ProductConfigurationDTO toDto(ProductConfiguration domain);

    ProductConfiguration toDomainFromDto(ProductConfigurationDTO dto);
}

