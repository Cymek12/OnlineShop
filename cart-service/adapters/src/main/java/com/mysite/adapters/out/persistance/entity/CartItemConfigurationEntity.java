package com.mysite.adapters.out.persistance.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_item_configuration")
@Getter
@Setter
public class CartItemConfigurationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String configurationType;
    private String value;
    private BigDecimal additionalPrice;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_item_id")
    private CartItemEntity cartItem;
}
