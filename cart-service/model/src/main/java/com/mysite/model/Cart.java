package com.mysite.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Cart {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Set<CartItem> addedProducts;
    private Long userId;

    public Cart() {
    }

    public Cart(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, Set<CartItem> addedProducts, Long userId) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.addedProducts = addedProducts;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CartItem> getAddedProducts() {
        return addedProducts;
    }

    public void setAddedProducts(Set<CartItem> addedProducts) {
        this.addedProducts = addedProducts;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
