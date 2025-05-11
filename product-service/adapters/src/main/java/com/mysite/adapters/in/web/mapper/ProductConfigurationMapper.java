package com.mysite.adapters.in.web.mapper;

import com.mysite.adapters.out.persistance.entity.ProductConfigurationEntity;
import com.mysite.model.ProductConfiguration;
import com.mysite.publicmodel.dto.ProductConfigurationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductConfigurationMapper {

    @Mapping(target = "product", ignore = true)
    List<ProductConfigurationDTO> toDtoListConfigurations(List<ProductConfiguration> configurations);

    @Mapping(target = "product", ignore = true)
    ProductConfigurationDTO toDto(ProductConfiguration config);

    @Mapping(target = "product", ignore = true)
    ProductConfiguration toDomain(ProductConfigurationEntity entity);

    @Mapping(target = "product", ignore = true)
    ProductConfigurationEntity toEntity(ProductConfiguration config);
}