package com.pizza_planet.store_front.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pizza_planet.store_front.Model.Pizza;
import com.pizza_planet.store_front.Model.Topping;
import com.pizza_planet.store_front.Repo.PizzaRepo;

@Service
public class PizzaService {
    private final PizzaRepo pizzaRepo;
    public PizzaService(PizzaRepo pizzaRepo) {
        this.pizzaRepo = pizzaRepo;
    }
    public List<Pizza> getAllPizzas() {
        return pizzaRepo.findAll();
    }
    public Pizza getPizzaById(Long id) {
        Optional<Pizza> pizza = pizzaRepo.findById(id);
        if (pizza.isPresent()) {
            for(Topping topping : pizza.get().getToppings()) {
                System.out.println("Topping: " + topping.getName());
            }
            return pizza.get();
        } else {
            throw new RuntimeException("Pizza not found with id: " + id);   
        }   
    }
    public Pizza getPizzaByName(String name){
        //noirmalize name to lower case but with first letter capitalized and remove spaces
        String normalizedName = name.toLowerCase().replaceAll("\\s+", "");
        normalizedName = normalizedName.substring(0, 1).toUpperCase() + normalizedName.substring(1);
        Optional<Pizza> pizza = pizzaRepo.findByName(normalizedName);
        if (pizza.isPresent()) {
            for(Topping topping : pizza.get().getToppings()) {
                System.out.println("Topping: " + topping.getName());
            }
            return pizza.get();
        } else {
            throw new RuntimeException("Pizza not found with name: " + name);
        }
    }
}
