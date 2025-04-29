package com.mysite.adapters.out.persistance;

import com.mysite.adapters.in.web.mapper.ProductMapper;
import com.mysite.adapters.out.persistance.entity.ProductEntity;
import com.mysite.core.port.out.ProductPort;
import com.mysite.model.PageContent;
import com.mysite.model.MyPageable;
import com.mysite.model.Product;
import com.mysite.model.ProductType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ProductRepository implements ProductPort {
    private final SpringDataProductRepository repository;
    private final ProductMapper productMapper;


    @Override
    public Product save(Product product) {
        ProductEntity savedEntity = repository.save(productMapper.toEntity(product));
        return productMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<ProductEntity> optionalProductEntity = repository.findById(id);
        if (optionalProductEntity.isPresent()) {
            return optionalProductEntity.map(productMapper::toDomain);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean existsByName(String name) {
        return repository.existsByName(name);
    }

    @Override
    public void delete(Product product) {
        ProductEntity entity = productMapper.toEntity(product);
        repository.delete(entity);
    }

    @Override
    public PageContent<Product> findAll(MyPageable myPageable) {
        Pageable pageable = PageRequest.of(myPageable.getPage(), myPageable.getSize());
        Page<ProductEntity> pageContent = repository.findAll(pageable);
        List<Product> list = pageContent.getContent().stream().map(productMapper::toDomain).toList();
        return new PageContent<>(
                pageContent.getTotalElements(),
                pageContent.getNumber(),
                pageContent.getTotalPages(),
                list);
    }

    @Override
    public PageContent<Product> findByProductType(ProductType productType, MyPageable myPageable) {
        Pageable pageable = PageRequest.of(myPageable.getPage(), myPageable.getSize());
        Page<ProductEntity> pageContent = repository.findByProductType(productType, pageable);
        List<Product> list = pageContent.getContent().stream().map(productMapper::toDomain).toList();
        return new PageContent<>(
                pageContent.getTotalElements(),
                pageContent.getNumber(),
                pageContent.getTotalPages(),
                list
        );
    }
}
