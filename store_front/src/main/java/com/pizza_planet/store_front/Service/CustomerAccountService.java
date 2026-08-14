package com.pizza_planet.store_front.Service;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pizza_planet.store_front.Model.Account;
import com.pizza_planet.store_front.Model.Customer;
import com.pizza_planet.store_front.Repo.CustomerRepo;

@Service
public class CustomerAccountService {
    private final PasswordEncoder encoder;
    private final CustomerRepo customerRepo;
    public CustomerAccountService(PasswordEncoder enc, CustomerRepo repo){
        this.encoder = enc;
        this.customerRepo = repo;
    }
    public Customer createAccount(Customer account){
        return customerRepo.save(account);
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
}
