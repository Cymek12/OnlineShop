package com.mysite.core.service;

import com.mysite.core.exception.ProductAlreadyExistsException;
import com.mysite.core.exception.ProductDataCannotBeNull;
import com.mysite.core.exception.ProductNotFoundException;
import com.mysite.core.port.in.ProductUseCase;
import com.mysite.core.port.out.ProductPort;
import com.mysite.model.*;

public class ProductService implements ProductUseCase {
    private final ProductPort productPort;

    public ProductService(ProductPort productPort) {
        this.productPort = productPort;
    }

    @Override
    public Product addProduct(Product product) {
        if (productPort.existsByName(product.getName())) {
            throw new ProductAlreadyExistsException("Product with name: " + product.getName() + " already exists");
        }
        validateProductData(product);
        return productPort.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productPort.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id: " + id + " does not exists"));
    }

    @Override
    public PageContent<Product> getAllProducts(MyPageable pageable, String productTypeCommand) {
        if (productTypeCommand != null) {
            ProductType productType = ProductType.valueOf(productTypeCommand.toUpperCase());
            return productPort.findByProductType(productType, pageable);
        }
        return productPort.findAll(pageable);
    }

    @Override
    public Product updateProduct(Long idProductToUpdate, Product productNewData) {
        Product productToUpdate = getProductById(idProductToUpdate);
        validateProductData(productNewData);
        productToUpdate.update(productNewData);
        return productPort.save(productToUpdate);
    }

    @Override
    public void deleteProduct(Long id) {
        Product productToDelete = getProductById(id);
        productPort.delete(productToDelete);
    }

    private void validateProductData(Product product) {
        if (product.isProductDataNull()) {
            throw new ProductDataCannotBeNull("Product data cannot be null");
        }
        if (!product.isProductConfigurationListCorrect()) {
            throw new ProductDataCannotBeNull("Product type other than electronics must have a configuration list");
        }
        for (ProductConfiguration configuration : product.getConfigurations()) {
            if (configuration.isProductDataNull()) {
                throw new ProductDataCannotBeNull("Product configuration data cannot be null");
            }
        }
    }
}
