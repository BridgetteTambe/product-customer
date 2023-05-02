package com.bree.com.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public RuntimeException runtimeException(RuntimeException e){
        return e;
    }

    @ExceptionHandler
    public Exception exception(Exception e){
        return e;
    }
}
