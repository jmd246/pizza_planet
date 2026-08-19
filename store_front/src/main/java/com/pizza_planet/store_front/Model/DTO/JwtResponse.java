package com.pizza_planet.store_front.Model.DTO;

public class JwtResponse {
    private final String token;

    public JwtResponse(String token) {
        this.token = token;
    }
    public String getToken() {
        return token;
    }
    @Override
    public String toString() {
        return "JwtResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
