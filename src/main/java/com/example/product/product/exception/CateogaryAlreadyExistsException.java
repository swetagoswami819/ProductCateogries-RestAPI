package com.example.product.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CateogaryAlreadyExistsException extends RuntimeException {
    public CateogaryAlreadyExistsException(String message){
        super(message);
    }

    
}
