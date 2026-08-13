package com.pizza_planet.store_front.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizza_planet.store_front.Model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long> {
    
}
