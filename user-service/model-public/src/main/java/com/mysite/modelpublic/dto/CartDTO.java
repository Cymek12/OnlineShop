package com.mysite.modelpublic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartDTO {
    private Long id;
    private List<CartItemDTO> addedProducts;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;
}