package com.pizza_planet.store_front.Service;
import com.pizza_planet.store_front.Model.Pizza;
import com.pizza_planet.store_front.Repo.PizzaRepo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    private final PizzaRepo pizzaRepo;
    public PizzaService(PizzaRepo pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }
    public List<Pizza> getAllPizzas() {
        return pizzaRepo.findAll();
    }
}
