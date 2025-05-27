package com.mysite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductConfiguration {
    private Long id;
    private String name;
    private String value;
    private BigDecimal additionalPrice;
    private Long productId;

    public boolean isProductDataNull() {
        return Objects.isNull(this.getName()) ||
                Objects.isNull(this.getValue()) ||
                Objects.isNull(this.getAdditionalPrice());
    }
}
