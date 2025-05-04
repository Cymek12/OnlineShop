package com.mysite.adapters.out.persistance;

import com.mysite.adapters.out.persistance.entity.CartItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataCartItemRepository extends JpaRepository<CartItemEntity, Long> {

}
