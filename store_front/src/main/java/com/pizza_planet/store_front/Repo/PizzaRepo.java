package com.pizza_planet.store_front.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizza_planet.store_front.Model.Pizza;

public interface PizzaRepo extends JpaRepository<Pizza, Long> {
    @Override
    List<Pizza> findAll();

    List<Pizza> findAllById(Iterable<Long> ids);

    java.util.Optional<Pizza> findById(Long id);

    java.util.Optional<Pizza> findByName(String name);
}
