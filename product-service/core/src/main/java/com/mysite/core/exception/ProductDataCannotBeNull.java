package com.mysite.core.exception;

public class ProductDataCannotBeNull extends BadRequestException {
    public ProductDataCannotBeNull(String message) {
        super(message);
    }
}
