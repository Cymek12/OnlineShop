package com.mysite.core.exception;

public class ProductAlreadyExistsException extends WebException {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
