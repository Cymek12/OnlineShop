package com.mysite.adapters.in.web.mapper;

import com.mysite.adapters.out.persistance.entity.ProductConfigurationEntity;
import com.mysite.adapters.out.persistance.entity.ProductEntity;
import com.mysite.model.Product;
import com.mysite.model.ProductConfiguration;
import com.mysite.publicmodel.command.ProductCommand;
import com.mysite.publicmodel.dto.ProductConfigurationDTO;
import com.mysite.publicmodel.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductConfigurationMapper.class)
public interface ProductMapper {


//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "name", target = "name")
//    @Mapping(source = "price", target = "price")
//    @Mapping(source = "productType", target = "productType")
//    @Mapping(source = "configurations", target = "configurations")
    ProductEntity toEntity(Product product);

    Product toDomain(ProductEntity entity);

    Product toDomain(ProductCommand productCommand);

    ProductDTO toDto(Product product);

    List<ProductDTO> toDtoListProducts(List<Product> products);
}