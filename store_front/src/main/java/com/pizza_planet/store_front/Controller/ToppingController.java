package com.pizza_planet.store_front.Controller;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pizza_planet.store_front.Model.Topping;
import com.pizza_planet.store_front.Service.ToppingService;


@RestController
public class ToppingController {
    private final ToppingService toppingService;
    public ToppingController(ToppingService toppingService) {
        this.toppingService = toppingService;
    }

    @GetMapping("/toppings")
    public ResponseEntity<?>
     getToppings(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Long id
    ) { 
        // If both name and id are provided, prioritize id
        if (name != null && id == null) {
            return ResponseEntity.ok(toppingService.fetchTopping(name));
        } else if (id != null) {
            return ResponseEntity.ok(toppingService.fetchTopping(id));
        }
        //if no id or name is provided
        return ResponseEntity.ok(toppingService.fetchToppings());
    }

    @PostMapping("/toppings/add")
    public ResponseEntity<Topping>
     addTopping(@RequestBody Topping entity) {
        return ResponseEntity.ok(toppingService.addTopping(entity) );
    }
    @PatchMapping("/toppings/update/{id}")
    public ResponseEntity<Topping>
     updateTopping(@RequestParam Long id,
        @RequestBody Topping entity
    ) {
        return ResponseEntity.ok(toppingService.updateTopping(id,entity) );
    }

    //take in a list of toppings then store in the database
    @PostMapping("toppings/upload-list")
    public ResponseEntity<?> uploadToppings(@RequestBody List<Topping> toppings) {
        try {
            return ResponseEntity.ok(toppingService.addToppings(toppings));
            
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                "error:    Topping already exists"
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                "error:    " + e.getMessage()
            );
        }
        
    }

}
