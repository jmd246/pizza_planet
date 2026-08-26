package com.pizza_planet.store_front.Util;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.pizza_planet.store_front.Model.DTO.JwtResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
@Component
public class JWTTokenUtil {
    /*
    
    What is a JWT token
    is a compact signed string that contains:
    user
    ttl
    roles/claims
    */
    private final String secret = "my-super-secret-key-for-jwt-siginging-12345";
    private final int min = 15;
    private final Long ttl = min * 60 * 1000L;
    //generate token
    //take in a user an assign the token their role,username,and ttl
    public JwtResponse generateToken(String id){
        String token = Jwts.builder()
                .setSubject(id)
                .issuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + ttl))
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
        return new JwtResponse(token);
    }
    //extract username
    public String extractUserID(String token){
        return Jwts.parser()
                .setSigningKey(secret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
    public Date extractTTL(String token){
        return Jwts.parser()
                .setSigningKey(secret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

}
