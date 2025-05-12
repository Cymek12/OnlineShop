package com.mysite.adapters;

import com.mysite.model.Product;
import com.mysite.model.ProductConfiguration;
import com.mysite.model.ProductType;
import com.mysite.publicmodel.command.ProductCommand;
import com.mysite.publicmodel.command.ProductConfigurationCommand;
import com.mysite.publicmodel.dto.ProductConfigurationDTO;
import com.mysite.publicmodel.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestDataBuilder {

    public static ProductConfigurationCommand buildProductConfigurationCommand(String value) {
        BigDecimal price = new BigDecimal("100.00");
        return new ProductConfigurationCommand("processor", value, price);
    }

    public static ProductCommand buildProductCommand() {
        BigDecimal price = new BigDecimal("100.00");
        return new ProductCommand("computer", price, ProductType.COMPUTER, List.of(
                        buildProductConfigurationCommand("intel"),
                        buildProductConfigurationCommand("amd"))
        );
    }

    public static ProductConfigurationDTO buildProductConfigurationDTO(Long id, String value) {
        BigDecimal price = new BigDecimal("100.00");
        return new ProductConfigurationDTO(id, "processor", value, price);
    }

    public static ProductDTO buildProductDTO() {
        BigDecimal price = new BigDecimal("100.00");
        return new ProductDTO(1L, "computer", price, ProductType.COMPUTER, List.of(
                buildProductConfigurationDTO(1L, "intel"),
                buildProductConfigurationDTO(2L, "amd")
        ));
    }

    public static Product buildProduct() {
        BigDecimal price = new BigDecimal("100.00");
        return new Product(1L, "computer", price, ProductType.COMPUTER, new ArrayList<>());
    }
}
