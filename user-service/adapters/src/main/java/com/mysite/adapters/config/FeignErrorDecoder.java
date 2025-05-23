package com.mysite.adapters.config;

import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        FeignException exception = FeignException.errorStatus(methodKey, response);
        if (response.status() == 503) {
            return new RetryableException(response.status(), exception.getMessage(), response.request().httpMethod(), exception, (Long) null, response.request());
        }
        return exception;
    }
}
