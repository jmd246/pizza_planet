package com.pizza_planet.store_front.Controller;

import java.util.Map;
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
        //check body for a valid customer object
        Map<String, String> json_error =  Map.of(
                    "error", "invalid_request",
                    "message", "Invalid request body"
                );
        if (customerInfo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                json_error
            );
        }
        if(customerInfo.getName() == null || customerInfo.getUsername() == null || customerInfo.getPassword() == null) {
            return ResponseEntity.badRequest().body(json_error);
        }
        if(customerInfo.getPassword().length() < 8 || customerInfo.getUsername().length()  < 6 ){
            return ResponseEntity.badRequest().body(json_error);

        }
        Customer customer = new Customer(customerInfo.getName(),customerInfo.getUsername(),customerInfo.getPassword());
        accountService.createPassword(customer,customer.getPassword());
        try {
            Customer persistedCustomer = accountService.createAccount(customer);
      
            return ResponseEntity.ok(persistedCustomer);
        }
        catch(DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
            Map.of(
                "error", "account_exists",
                "message", "Username or email already exists"
            )
        );
        }
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
