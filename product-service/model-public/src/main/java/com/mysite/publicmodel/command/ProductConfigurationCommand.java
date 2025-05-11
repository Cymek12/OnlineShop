package com.mysite.publicmodel.command;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductConfigurationCommand {
    private String name;
    private String value;
    private BigDecimal additionalPrice;

}
