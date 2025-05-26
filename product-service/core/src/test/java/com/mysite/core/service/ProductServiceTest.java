package com.mysite.core.service;

import com.mysite.core.exception.ProductAlreadyExistsException;
import com.mysite.core.port.out.ProductPort;
import com.mysite.model.Product;
import com.mysite.model.ProductType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static com.mysite.core.service.TestDataBuilder.buildProduct;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ProductServiceTest {
    private ProductPort productPort;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        this.productPort = Mockito.mock(ProductPort.class);
        this.productService = new ProductService(productPort);
    }

    @Test
    void addProduct_productAdded_returnProduct() {
        Product product = buildProduct(1L);
        when(productPort.save(any())).thenReturn(product);

        Product resultProduct = productService.addProduct(product);

        assertEquals(1L, resultProduct.getId());
        assertEquals("computer", resultProduct.getName());
        assertEquals(new BigDecimal("100.00"), resultProduct.getPrice());
        assertEquals(ProductType.COMPUTER, resultProduct.getProductType());
    }

    @Test
    void addProduct_productAlreadyExists_ProductAlreadyExistExceptionThrown() {
        Product product = buildProduct(1L);
        when(productPort.existsByName(product.getName())).thenReturn(true);

        ProductAlreadyExistsException resultException = assertThrows(ProductAlreadyExistsException.class, () -> productService.addProduct(product));

        assertEquals("Product with name: " + product.getName() + " already exists", resultException.getMessage());
    }


}