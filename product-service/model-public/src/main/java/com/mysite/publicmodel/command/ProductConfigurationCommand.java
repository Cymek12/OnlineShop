package com.mysite.publicmodel.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductConfigurationCommand {
    private String name;
    private String value;
    private BigDecimal additionalPrice;
}
