package com.mysite.publicmodel.command;

import com.mysite.model.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCommand {
    private String name;
    private BigDecimal price;
    private ProductType productType;
    private List<ProductConfigurationCommand> configurations;
}
