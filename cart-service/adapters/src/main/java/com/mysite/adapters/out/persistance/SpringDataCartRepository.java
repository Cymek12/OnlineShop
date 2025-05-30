package com.mysite.adapters.out.persistance;

import com.mysite.adapters.out.persistance.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataCartRepository extends JpaRepository<CartEntity, Long> {

    Optional<CartEntity> findById(Long id);

    Optional<CartEntity> findByUserId(Long id);
}
