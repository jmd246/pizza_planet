package com.pizza_planet.store_front.ErrorTypes;
public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message) {
           super(message);
    }
    
}
