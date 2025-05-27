package com.mysite.adapters.in.web;

import com.mysite.adapters.in.web.mapper.ProductMapper;
import com.mysite.core.port.in.ProductService;
import com.mysite.model.*;
import com.mysite.publicmodel.command.ProductCommand;
import com.mysite.publicmodel.dto.ProductConfigurationDTO;
import com.mysite.publicmodel.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping
    public ProductDTO addProduct(@RequestBody ProductCommand productCommand) {
        Product product = productMapper.toDomain(productCommand);
        return productMapper.toDto(productService.addProduct(product));
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable("id") String id) {
        return productMapper.toDto(productService.getProductById(Long.valueOf(id)));
    }

    @GetMapping
    public PageContent<ProductDTO> getAllProducts(Pageable pageable, @RequestParam(name = "productType", required = false) String productType) {
        MyPageable myPageable = new MyPageable(pageable.getPageSize(), pageable.getPageNumber());
        PageContent<Product> productPageContent = productService.getAllProducts(myPageable, productType);
        List<ProductDTO> list = productPageContent.getContent().stream().map(productMapper::toDto).collect(Collectors.toList());
        return new PageContent<>(productPageContent.getTotalElements(),
                productPageContent.getCurrentPage(),
                productPageContent.getTotalPageNumber(),
                list);
    }

    @PatchMapping("/{id}")
    public ProductDTO updateProductById(@PathVariable("id") String id, @RequestBody ProductCommand productCommand) {
        Product product = productMapper.toDomain(productCommand);
        Product updatedProduct = productService.updateProduct(Long.valueOf(id), product);
        return productMapper.toDto(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") String id) {
        productService.deleteProduct(Long.valueOf(id));
    }

    @GetMapping("/{id}/configuration")
    public List<ProductConfigurationDTO> getProductConfigurationById(@PathVariable("id") String id) {
        List<ProductConfiguration> configurations = productService
                .getProductById(Long.valueOf(id))
                .getConfigurations();
        return configurations.stream().map(productMapper::toDto).collect(Collectors.toList());
    }
}
