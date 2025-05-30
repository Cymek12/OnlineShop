package com.mysite.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CartItem {
    private Long id;
    private Long productId;
    private Long quantity;
    private BigDecimal price;
    private Long cartId;
    private List<CartItemConfiguration> chosenConfiguration;

    public boolean isCartItemDataNull() {
        return Objects.isNull(this.getCartId()) ||
                Objects.isNull(this.getProductId()) ||
                Objects.isNull(this.getQuantity()) ||
                Objects.isNull(this.getPrice()) ||
                Objects.isNull(this.getChosenConfiguration());
    }
}
