package com.adminPanel.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductNotFoundExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handleException(ProductNotFoundException e) {
        ProductErrorResponse response = new ProductErrorResponse();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(e.getMessage());
 return new  ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}



