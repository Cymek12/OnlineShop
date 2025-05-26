package com.mysite.core.exception;

public class ProductAlreadyExistsException extends BadRequestException {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
