package com.pizza_planet.store_front.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizza_planet.store_front.Model.Customer;
import java.util.Optional;


public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Optional<Customer> findByUsername(String username); 
}
