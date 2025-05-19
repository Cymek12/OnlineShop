package com.mysite.adapters.in.web.handler;

import com.mysite.adapters.in.web.dto.ErrorMessage;
import com.mysite.core.exception.BadRequestException;
import com.mysite.core.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(exception = NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request) {
        ErrorMessage body = new ErrorMessage(ex.getMessage(), new Date(), HttpStatus.NOT_FOUND);
        return handleExceptionInternal(ex, body, new HttpHeaders(), body.getStatus(), request);
    }

    @ExceptionHandler(exception = BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ErrorMessage body = new ErrorMessage(ex.getMessage(), new Date(), HttpStatus.BAD_REQUEST);
        return handleExceptionInternal(ex, body, new HttpHeaders(), body.getStatus(), request);
    }
}



