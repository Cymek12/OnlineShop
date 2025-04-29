package com.mysite.core.exception;

public class ProductNotFoundException extends WebException{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
