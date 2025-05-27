package com.mysite.adapters.in.web.mapper;

import com.mysite.adapters.out.persistance.entity.ProductConfigurationEntity;
import com.mysite.adapters.out.persistance.entity.ProductEntity;
import com.mysite.model.Product;
import com.mysite.model.ProductConfiguration;
import com.mysite.publicmodel.command.ProductCommand;
import com.mysite.publicmodel.command.ProductConfigurationCommand;
import com.mysite.publicmodel.dto.ProductConfigurationDTO;
import com.mysite.publicmodel.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toDomain(ProductEntity productEntity);

    ProductEntity toEntity(Product product);

    ProductDTO toDto(Product product);

    ProductConfiguration toDomain(ProductConfigurationEntity entity);

    ProductConfigurationEntity toEntity(ProductConfiguration domain);

    ProductConfigurationDTO toDto(ProductConfiguration domain);

    Product toDomain(ProductCommand productCommand);

    ProductConfiguration toDomain(ProductConfigurationCommand command);
}