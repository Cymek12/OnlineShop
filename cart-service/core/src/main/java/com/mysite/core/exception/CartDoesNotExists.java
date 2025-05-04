package com.mysite.core.exception;

public class CartDoesNotExists extends WebException {
    public CartDoesNotExists(String message) {
        super(message);
    }
}
