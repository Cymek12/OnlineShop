package com.mysite.adapters.out.persistance;

import com.mysite.adapters.out.persistance.entity.ProductEntity;
import com.mysite.model.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository extends JpaRepository<ProductEntity, Long> {
    boolean existsByName(String name);

    Page<ProductEntity> findAll(Pageable pageable);

    Page<ProductEntity> findByProductType(ProductType productType, Pageable pageable);

}
