package com.mysite.adapters.out.persistance;

import com.mysite.adapters.out.persistance.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SpringDataCartRepository extends JpaRepository<CartEntity, Long> {
    boolean existsById(Long id);

    @Query("SELECT c FROM CartEntity c " +
            "LEFT JOIN FETCH c.addedProducts p " +
            "LEFT JOIN FETCH p.chosenConfiguration " +
            "WHERE c.userId = :userId")
    Optional<CartEntity> findFullByUserId(@Param("userId") Long userId);

    Optional<CartEntity> findById(Long id);

    Optional<CartEntity> findByUserId(Long id);
}
