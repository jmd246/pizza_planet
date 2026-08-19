package com.pizza_planet.store_front.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.pizza_planet.store_front.Model.Topping;
import com.pizza_planet.store_front.Model.ToppingType;
import com.pizza_planet.store_front.Repo.ToppingRepo;

@Service
public class ToppingService {
    private final ToppingRepo toppingRepo;

    public ToppingService(ToppingRepo toppingRepo) {
        this.toppingRepo = toppingRepo;
    }
    public List<Topping> fetchToppings(){
        return toppingRepo.findAll();
    }
    public Topping fetchTopping(Long id){
        return toppingRepo.findById(id).orElseThrow(()->{
            throw new NoSuchElementException("Topping not found with id: " + id);
        });
    }
    public Topping fetchTopping(String name){
        return toppingRepo.findByName(name);
    }
    public Topping addTopping(Topping topping){
        
        return toppingRepo.save(topping);
    }
    public Topping updateTopping(Long id,String name){
        Topping topping = toppingRepo.findById(id).get();
        topping.setName(name);
        return toppingRepo.save(topping);
    }
    public Topping updateTopping(Long id,ToppingType type){
        Topping tpping = toppingRepo.findById(id).get();
        tpping.setType(type);
        return toppingRepo.save(tpping);
    }
    public Topping updateTopping(Long id,Topping newTopping){
        Topping tpping = toppingRepo.findById(id).get();
        tpping.setName(newTopping.getName());
        tpping.setType(newTopping.getType());
        return toppingRepo.save(tpping);
    }
    public List<Topping> addToppings(List<Topping> toppings){
        return toppingRepo.saveAll(toppings);
    }
    public List<Topping> updateToppings(List<Topping> toppings){
        return toppingRepo.saveAll(toppings);
    }
    public List<Topping> geToppings(){
        return toppingRepo.findAll();
    }


    
    
}
