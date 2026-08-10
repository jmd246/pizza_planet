package com.pizza_planet.store_front.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizza_planet.store_front.Model.Topping;

public interface ToppingRepo extends JpaRepository<Topping, Integer> {
    List<Topping> findAll();
}
