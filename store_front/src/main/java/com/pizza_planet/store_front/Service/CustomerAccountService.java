package com.pizza_planet.store_front.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.pizza_planet.store_front.Repo.CustomerRepo;
import com.pizza_planet.store_front.Model.Account;
import com.pizza_planet.store_front.Model.Customer;
import java.util.Optional;

@Service
public class CustomerAccountService {
    private final PasswordEncoder encoder;
    private final CustomerRepo customerRepo;
    public CustomerAccountService(PasswordEncoder enc, CustomerRepo repo){
        this.encoder = enc;
        this.customerRepo = repo;
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
