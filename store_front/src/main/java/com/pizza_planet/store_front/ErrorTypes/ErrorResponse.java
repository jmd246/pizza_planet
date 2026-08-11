package com.pizza_planet.store_front.ErrorTypes;
import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private String message;
    private HttpStatus statusCode;

    public ErrorResponse(String message, HttpStatus  statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
    
}
