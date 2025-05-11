package com.mysite.adapters.in.web;

import com.mysite.adapters.in.web.mapper.ProductConfigurationMapper;
import com.mysite.adapters.in.web.mapper.ProductMapper;
import com.mysite.core.port.in.ProductUseCase;
import com.mysite.model.*;
import com.mysite.publicmodel.command.ProductCommand;
import com.mysite.publicmodel.dto.ProductConfigurationDTO;
import com.mysite.publicmodel.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductUseCase productUseCase;
    private final ProductMapper productMapper;
    private final ProductConfigurationMapper productConfigurationMapper;

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductCommand productCommand) {
        Product product = productMapper.toDomain(productCommand);
        return productMapper.toDto(productUseCase.addProduct(product));
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable("id") String id) {
        return productMapper.toDto(productUseCase.getProductById(Long.valueOf(id)));
    }

    @GetMapping
    public PageContent<ProductDTO> getAllProducts(Pageable pageable, @RequestParam(required = false) String productType) {
        MyPageable myPageable = new MyPageable(pageable.getPageSize(), pageable.getPageNumber());
        PageContent<Product> productPageContent = productUseCase.getAllProducts(myPageable, productType);
        List<ProductDTO> list = productMapper.toDtoListProducts(productPageContent.getContent());
        return new PageContent<>(productPageContent.getTotalElements(),
                productPageContent.getCurrentPage(),
                productPageContent.getTotalPageNumber(),
                list);
    }

    @PatchMapping("/{id}")
    public ProductDTO updateProductById(@PathVariable("id") String id, @RequestBody ProductCommand productCommand) {
        Product product = productMapper.toDomain(productCommand);
        Product updatedProduct = productUseCase.updateProduct(Long.valueOf(id), product);
        return productMapper.toDto(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") String id) {
        productUseCase.deleteProduct(Long.valueOf(id));
    }

    @GetMapping("/{id}/configuration")
    public List<ProductConfigurationDTO> getProductConfigurationById(@PathVariable("id") String id) {
        List<ProductConfiguration> configurations = productUseCase
                .getProductById(Long.valueOf(id))
                .getConfigurations();
        return configurations.stream().map(productConfigurationMapper::toDto).toList();
    }
}
