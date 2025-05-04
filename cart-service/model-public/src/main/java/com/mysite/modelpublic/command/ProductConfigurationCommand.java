package com.mysite.modelpublic.command;

import java.math.BigDecimal;

public class ProductConfigurationCommand {
    private String configurationType;
    private String value;
    private BigDecimal additionalPrice;

    public ProductConfigurationCommand(String configurationType, String value, BigDecimal additionalPrice) {
        this.configurationType = configurationType;
        this.value = value;
        this.additionalPrice = additionalPrice;
    }

    public ProductConfigurationCommand() {
    }

    public String getConfigurationType() {
        return configurationType;
    }

    public void setConfigurationType(String configurationType) {
        this.configurationType = configurationType;
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
