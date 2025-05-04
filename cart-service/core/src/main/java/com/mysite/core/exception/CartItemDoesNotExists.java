package com.mysite.core.exception;

public class CartItemDoesNotExists extends WebException{
    public CartItemDoesNotExists(String message) {
        super(message);
    }
}
