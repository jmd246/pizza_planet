package com.pizza_planet.store_front.Service;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pizza_planet.store_front.Model.Account;
import com.pizza_planet.store_front.Model.Customer;
import com.pizza_planet.store_front.Model.DTO.CustomerDTO;
import com.pizza_planet.store_front.Model.DTO.JwtResponse;
import com.pizza_planet.store_front.Repo.CustomerRepo;
import com.pizza_planet.store_front.Util.AccountValidationTool;
import com.pizza_planet.store_front.Util.JWTTokenUtil;
import com.pizza_planet.store_front.Model.DTO.LoginRequest;

@Service
public class CustomerAccountService {
    private final PasswordEncoder encoder;
    private final CustomerRepo customerRepo;
    private final JWTTokenUtil helper;
    private final AccountValidationTool validator;
    public CustomerAccountService(PasswordEncoder enc, CustomerRepo repo, JWTTokenUtil jwt){
        this.encoder = enc;
        this.customerRepo = repo;
        this.helper = jwt;
        this.validator = new AccountValidationTool();
    }
    public Optional<Customer> createAccount(CustomerDTO account) throws IllegalArgumentException{
        //validate account
        boolean isValid = validator.isValidUsername(account.getUsername()) &&
         validator.isValidPassword(account.getPassword()) && 
         validator.isValidEmail(account.getEmail());
        if(!isValid){
            throw new IllegalArgumentException("MISSING INFO");
        }
        Customer customer = new Customer(
            account.getName(),
            account.getUsername(),
            account.getPassword(),
            account.getEmail()
        );
        createPassword(customer,customer.getPassword());
        return Optional.of(customerRepo.save(customer));
    }
    public void createPassword(Account account,String raw){
        String hashed_pw = encoder.encode(raw);
        account.setPassword(hashed_pw);
    }
    public boolean checkPassword(String rawPassword,Account acc){
        return encoder.matches(rawPassword,acc.getPassword());
    }
    public Optional<Customer> fetchWithUserName(String username){
        return customerRepo.findByUsername(username);
    }
    public Optional<JwtResponse> login(LoginRequest accInfo){
        //fetch account
        if(!validator.isValidUsername(accInfo.getUsername())){
            return Optional.empty();
        }
        else if(!validator.isValidPassword(accInfo.getPassword())){
            return Optional.empty();
        }
        else{ 
         
            Optional<Customer> account = fetchWithUserName(accInfo.getUsername());
            Optional<JwtResponse> token = Optional.of(helper.generateToken(account.get().getUsername()));
            return token;
        }
    }


    


 
}
