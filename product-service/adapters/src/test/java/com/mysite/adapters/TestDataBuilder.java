package com.mysite.adapters;

import com.mysite.model.ProductType;
import com.mysite.publicmodel.command.ProductCommand;
import com.mysite.publicmodel.command.ProductConfigurationCommand;
import com.mysite.publicmodel.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;

public class TestDataBuilder {

    public static ProductConfigurationCommand buildProductConfigurationCommand(String value) {
        BigDecimal price = new BigDecimal("100.00");
        return ProductConfigurationCommand.builder()
                .name("processor")
                .value(value)
                .additionalPrice(price)
                .build();
    }

    public static ProductCommand buildProductCommand() {
        BigDecimal price = new BigDecimal("100.00");
        return ProductCommand.builder()
                .name("computer")
                .price(price)
                .productType(ProductType.COMPUTER)
                .configurations(List.of(
                        buildProductConfigurationCommand("intel"),
                        buildProductConfigurationCommand("amd")
                ))
                .build();
    }

    public static ProductDTO buildProductDTO() {
        return ProductDTO.
    }
}
