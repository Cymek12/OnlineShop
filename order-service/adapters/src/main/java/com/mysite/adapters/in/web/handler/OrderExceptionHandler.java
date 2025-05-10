package com.mysite.adapters.in.web.handler;


import com.mysite.adapters.in.web.dto.ErrorMessage;
import com.mysite.core.exception.WebException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class OrderExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(exception = WebException.class)
    public ResponseEntity<Object> handleWebException(WebException ex, WebRequest request) {
        ErrorMessage body = new ErrorMessage(ex.getMessage(), new Date());
        return handleExceptionInternal(ex, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
