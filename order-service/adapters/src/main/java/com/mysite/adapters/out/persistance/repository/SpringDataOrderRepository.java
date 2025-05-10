package com.mysite.adapters.out.persistance.repository;

import com.mysite.adapters.out.persistance.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataOrderRepository extends JpaRepository<OrderEntity, Long> {

}
