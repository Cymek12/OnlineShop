package com.mysite.adapters.out.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_item")
@Setter
@Getter
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private Long quantity;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;
    @OneToMany(mappedBy = "cartItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItemConfigurationEntity> chosenConfiguration;
}
