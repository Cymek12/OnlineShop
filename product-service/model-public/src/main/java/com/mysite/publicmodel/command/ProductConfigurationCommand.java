package com.mysite.publicmodel.command;



import java.math.BigDecimal;



public class ProductConfigurationCommand {
    private String name;
    private String value;
    private BigDecimal additionalPrice;

    public ProductConfigurationCommand(String name, String value, BigDecimal additionalPrice) {
        this.name = name;
        this.value = value;
        this.additionalPrice = additionalPrice;
    }

    public ProductConfigurationCommand() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BigDecimal getAdditionalPrice() {
        return additionalPrice;
    }

    public void setAdditionalPrice(BigDecimal additionalPrice) {
        this.additionalPrice = additionalPrice;
    }
}
