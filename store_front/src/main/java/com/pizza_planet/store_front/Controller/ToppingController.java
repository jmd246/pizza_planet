package com.pizza_planet.store_front.Controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizza_planet.store_front.Model.Topping;
import com.pizza_planet.store_front.Repo.ToppingRepo;
@RestController
public class ToppingController {
    private final ToppingRepo toppingRepo;
    public ToppingController(ToppingRepo toppingRepo) {
        this.toppingRepo = toppingRepo;
    }

    @GetMapping("/toppings")
    public ResponseEntity<List<Topping>> getToppings() {
        return ResponseEntity.ok(toppingRepo.findAll());
    }
}
