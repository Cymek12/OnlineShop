package com.mysite.model;

import java.time.LocalDateTime;
import java.util.List;

public class Cart {
    private Long id;
    private List<CartItem> addedProducts;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;

    public Cart() {
    }

    public Cart(Long id, List<CartItem> addedProducts, LocalDateTime createdAt, LocalDateTime updatedAt, Long userId) {
        this.id = id;
        this.addedProducts = addedProducts;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItem> getAddedProducts() {
        return addedProducts;
    }

    public void setAddedProducts(List<CartItem> addedProducts) {
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
