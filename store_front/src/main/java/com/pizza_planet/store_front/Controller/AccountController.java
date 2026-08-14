package com.pizza_planet.store_front.Controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pizza_planet.store_front.Model.Customer;
import com.pizza_planet.store_front.Model.DTO.LoginRequest;
import com.pizza_planet.store_front.Service.CustomerAccountService;


@RestController
public class AccountController {
    private CustomerAccountService accountService; 
    public AccountController(CustomerAccountService service){
        this.accountService = service;
    }
    //home page
    @GetMapping("/")
    public ResponseEntity<String> Home(){
        return ResponseEntity.ok("Welcome To Pizza Planet");
    }
    //create an endpoint for creating a new account
    @PostMapping("/new_account")
    public ResponseEntity<Customer> CreateAccount(@RequestBody Customer customer) {
        //check body for a valid customer object
        if (customer == null) {
            return ResponseEntity.badRequest().build();
        }
        if(customer.getName() == null || customer.getUsername() == null || customer.getPassword() == null) {
            return ResponseEntity.badRequest().build();
        }
        if(customer.getPassword().length() < 8 || customer.getUsername().length()  < 6 ){
            return ResponseEntity.badRequest().build();

        }
        accountService.createPassword(customer,customer.getPassword());
        return ResponseEntity.ok(customer);
    }
    
    //create an endpoint for logging in
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest info) {
        //check if valid logim request
        if(info.getUsername() == null || info.getUsername().length() < 6){
            return ResponseEntity.badRequest().build();
        }
        else if(info.getPassword()==null || info.getPassword().length() < 8){
            return ResponseEntity.badRequest().build();
        }
        // grab user based on name provided trhen check the password
        Optional<Customer> pot_account = accountService.fetchWithUserName(info.getUsername());
        if (pot_account.isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        if (accountService.checkPassword(info.getPassword(),pot_account.get())){
            return ResponseEntity.ok(pot_account.get());
        }
        else{
            return ResponseEntity.badRequest().build();
        }
    }
    
    
    //create an endpoint for logging out
    //create an endpoint for updating account information

    
}
