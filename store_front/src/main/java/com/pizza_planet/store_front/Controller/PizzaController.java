package com.pizza_planet.store_front.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<List<Pizza>> getAllPizzas() {
        return ResponseEntity.ok(pizzaService.getAllPizzas());
    }
    
    
}
