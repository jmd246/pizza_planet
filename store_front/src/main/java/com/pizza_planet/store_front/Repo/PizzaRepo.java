package com.pizza_planet.store_front.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizza_planet.store_front.Model.Pizza;

public interface PizzaRepo extends JpaRepository<Pizza, Integer> {
    @Override
    List<Pizza> findAll();
}
