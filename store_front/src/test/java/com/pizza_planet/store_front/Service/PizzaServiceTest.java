package com.pizza_planet.store_front.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

import com.pizza_planet.store_front.Model.Pizza;
import com.pizza_planet.store_front.Repo.PizzaRepo;

public class PizzaServiceTest {
    @Mock
    PizzaRepo pizzaRepo = org.mockito.Mockito.mock(PizzaRepo.class);
    @Test
    void testGetAllPizzas() {
        when(pizzaRepo.findAll()).thenReturn(java.util.List.of(new Pizza("Margherita", 1L), new Pizza("Pepperoni", 2L)));
        assertEquals(2, pizzaRepo.findAll().size());
        assertEquals("Margherita", pizzaRepo.findAll().get(0).getName());
        assertEquals("Pepperoni", pizzaRepo.findAll().get(1).getName());
    }
    @Test
    void testGetPizzaById() {
        when(pizzaRepo.findById(1L)).thenReturn(java.util.Optional.of(new Pizza("Margherita", 1L)));
        PizzaService pizzaService = new PizzaService(pizzaRepo);
        Pizza pizza = pizzaService.getPizzaById(1L);
        assertEquals("Margherita", pizza.getName());
        assertEquals(1L, pizza.getId()); 


    }
}
