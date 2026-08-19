package com.pizza_planet.store_front.Controller;

import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizza_planet.store_front.Model.Customer;
import com.pizza_planet.store_front.Model.DTO.CustomerDTO;
import com.pizza_planet.store_front.Model.DTO.JwtResponse;
import com.pizza_planet.store_front.Model.DTO.LoginRequest;
import com.pizza_planet.store_front.Service.CustomerAccountService;


@RestController
public class AccountController {
    private final CustomerAccountService accountService; 
    public AccountController(CustomerAccountService service){
        this.accountService = service;
    }
    //home page
    @GetMapping("/")
    public ResponseEntity<String> Home(){
        return ResponseEntity.ok("Welcome To Pizza Planet");
    }
    //create an endpoint for creating a new account
    @PostMapping("/register")
    public ResponseEntity<?> CreateAccount(@RequestBody CustomerDTO customerInfo) {
        
        try{
            
            Optional<Customer> account = accountService.createAccount(customerInfo);            

            return ResponseEntity.ok(account);
        }
        catch(DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                "error:    Account already exists"
            );
        }
        catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                "error:    " + e.getMessage()
            );
        }
    }
    
    //create an endpoint for logging in
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest info) {
        Optional<JwtResponse> token = accountService.login(info);
        return ResponseEntity.ok(token);
    }
    
    //create an endpoint for logging out for not we will just output the token
    //blacklist a token so it can no longer be used until it expires
    //frontend will clear local storage and this will be called to render token invalid

    //create an endpoint for updating account information
    

    
}
