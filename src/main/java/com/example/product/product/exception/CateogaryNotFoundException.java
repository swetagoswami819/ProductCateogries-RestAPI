package com.example.product.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CateogaryNotFoundException extends RuntimeException {
    
    public CateogaryNotFoundException(String message){
        super(message);
    }
    
}
