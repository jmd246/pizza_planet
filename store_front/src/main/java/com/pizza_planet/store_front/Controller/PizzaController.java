package com.pizza_planet.store_front.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pizza_planet.store_front.Model.Pizza;
import com.pizza_planet.store_front.Service.PizzaService;


@RestController
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }
    @GetMapping("/pizzas")
    public ResponseEntity<?> getPizzas(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Long id 
    ) {
        // If both name and id are provided, prioritize id
        //if none are provided, return all pizzas
        if (name != null && id == null) {
            Pizza pizza = pizzaService.getPizzaByName(name);
            return ResponseEntity.ok(pizza);
        } else if (id != null) {
            Pizza pizza = pizzaService.getPizzaById(id);
            return ResponseEntity.ok(pizza);
        } else {
            List<Pizza> pizzas = pizzaService.getAllPizzas();
            return ResponseEntity.ok(pizzas);
        }
    }
    
    
}
