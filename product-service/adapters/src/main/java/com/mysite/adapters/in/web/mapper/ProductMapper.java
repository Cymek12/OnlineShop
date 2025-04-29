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

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductEntity toEntity(Product product) {
        if (product == null) {
            return null;
        }
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());
        entity.setProductType(product.getProductType());

        if (product.getConfigurations() != null) {
            List<ProductConfigurationEntity> configurationEntities = product.getConfigurations()
                    .stream()
                    .map(this::toEntity)
                    .collect(Collectors.toList());

            configurationEntities.forEach(config -> config.setProduct(entity));

            entity.setConfigurations(configurationEntities);
        }
        return entity;
    }

    public Product toDomain(ProductCommand productCommand) {
        if (productCommand == null) {
            return null;
        }
        List<ProductConfiguration> configurations = (productCommand.getConfigurations() != null)
                ? productCommand.getConfigurations()
                .stream()
                .map(this::toDomain)
                .toList()
                : List.of();

        return new Product(
                null,
                productCommand.getName(),
                productCommand.getPrice(),
                productCommand.getProductType(),
                configurations
        );
    }

    private ProductConfiguration toDomain(ProductConfigurationCommand productConfigurationCommand) {
        return new ProductConfiguration(
                null,
                productConfigurationCommand.getName(),
                productConfigurationCommand.getValue(),
                productConfigurationCommand.getAdditionalPrice(),
                null
        );
    }

    public Product toDomain(ProductEntity entity) {
        if (entity == null) {
            return null;
        }
        List<ProductConfiguration> configurations = null;
        if (entity.getConfigurations() != null) {
            configurations = entity.getConfigurations()
                    .stream()
                    .map(this::toDomain)
                    .collect(Collectors.toList());
        }
        return new Product(
                entity.getId(),
                entity.getName(),
                entity.getPrice(),
                entity.getProductType(),
                configurations
        );
    }

    public ProductDTO toDto(Product product) {
        if (product == null) {
            return null;
        }
        List<ProductConfigurationDTO> configurationDTOs = null;
        if (product.getConfigurations() != null) {
            configurationDTOs = product.getConfigurations()
                    .stream()
                    .map(pc -> new ProductConfigurationDTO(pc.getId(), pc.getName(), pc.getValue(), pc.getAdditionalPrice()))
                    .collect(Collectors.toList());
        }
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getProductType(),
                configurationDTOs
        );
    }

    private ProductConfigurationEntity toEntity(ProductConfiguration config) {
        if (config == null) {
            return null;
        }
        ProductConfigurationEntity entity = new ProductConfigurationEntity();
        entity.setId(config.getId());
        entity.setName(config.getName());
        entity.setValue(config.getValue());
        entity.setAdditionalPrice(config.getAdditionalPrice());
        return entity;
    }

    private ProductConfiguration toDomain(ProductConfigurationEntity entity) {
        if (entity == null) {
            return null;
        }
        return new ProductConfiguration(
                entity.getId(),
                entity.getName(),
                entity.getValue(),
                entity.getAdditionalPrice(),
                null
        );
    }

    public List<ProductDTO> toDtoList(List<Product> products) {
        return products.stream()
                .map(this::toDto)
                .toList();
    }

    public ProductConfigurationDTO toDto(ProductConfiguration config) {
        if (config == null) {
            return null;
        }
        return new ProductConfigurationDTO(
                config.getId(),
                config.getName(),
                config.getValue(),
                config.getAdditionalPrice()
        );
    }
}