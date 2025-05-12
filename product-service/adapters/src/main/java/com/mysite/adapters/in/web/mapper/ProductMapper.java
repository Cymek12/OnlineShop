package com.mysite.adapters.in.web.mapper;

import com.mysite.adapters.out.persistance.entity.ProductConfigurationEntity;
import com.mysite.adapters.out.persistance.entity.ProductEntity;
import com.mysite.model.Product;
import com.mysite.model.ProductConfiguration;
import com.mysite.publicmodel.command.ProductCommand;
import com.mysite.publicmodel.command.ProductConfigurationCommand;
import com.mysite.publicmodel.dto.ProductConfigurationDTO;
import com.mysite.publicmodel.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toDomain(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setName(productEntity.getName());
        product.setPrice(productEntity.getPrice());
        product.setProductType(productEntity.getProductType());
        product.setConfigurations(productEntity.getConfigurations().stream().map(this::toDomain).toList());
        return product;
    }

    public ProductEntity toEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setProductType(product.getProductType());
        productEntity.setConfigurations(product.getConfigurations().stream().map(this::toEntity).toList());
        return productEntity;
    }

    public ProductDTO toDto(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setProductType(product.getProductType());
        productDTO.setConfigurations(product.getConfigurations().stream().map(this::toDto).toList());
        return productDTO;
    }

    public ProductConfiguration toDomain(ProductConfigurationEntity entity) {
        ProductConfiguration domain = new ProductConfiguration();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setValue(entity.getValue());
        domain.setAdditionalPrice(entity.getAdditionalPrice());
        domain.setProductId(entity.getProduct().getId());
        return domain;
    }

    public ProductConfigurationEntity toEntity(ProductConfiguration domain) {
        ProductConfigurationEntity entity = new ProductConfigurationEntity();
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(domain.getId());
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setValue(domain.getValue());
        entity.setAdditionalPrice(domain.getAdditionalPrice());
        entity.setProduct(productEntity);
        return entity;
    }

    public ProductConfigurationDTO toDto(ProductConfiguration domain) {
        ProductConfigurationDTO dto = new ProductConfigurationDTO();
        dto.setId(domain.getId());
        dto.setName(domain.getName());
        dto.setValue(domain.getValue());
        dto.setAdditionalPrice(domain.getAdditionalPrice());
        return dto;
    }

    public Product toDomain(ProductCommand productCommand) {
        Product product = new Product();
        product.setName(productCommand.getName());
        product.setProductType(productCommand.getProductType());
        product.setPrice(productCommand.getPrice());
        product.setConfigurations(productCommand.getConfigurations().stream().map(this::toDomain).toList());
        return product;
    }

    public ProductConfiguration toDomain(ProductConfigurationCommand command) {
        ProductConfiguration domain = new ProductConfiguration();
        domain.setName(command.getName());
        domain.setValue(command.getValue());
        domain.setAdditionalPrice(command.getAdditionalPrice());
        return domain;
    }
}