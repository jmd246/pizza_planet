package com.pizza_planet.store_front.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pizza_planet.store_front.ErrorTypes.ErrorResponse;
import com.pizza_planet.store_front.ErrorTypes.ResourceNotFound;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFound ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), org.springframework.http.HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse, org.springframework.http.HttpStatus.NOT_FOUND);
    }
    //handle other exceptions as needed
    //general exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorResponse, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}
