package com.pizza_planet.store_front.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pizza_planet.store_front.Model.Topping;
import com.pizza_planet.store_front.Model.ToppingType;
import com.pizza_planet.store_front.Repo.ToppingRepo;

/*
    Arrange
    ↓
    Mock repository
    ↓
    Call service
    ↓
    Assert result
    ↓
    Verify repository
*/
@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class ToppingServiceTest {
    @Mock
    ToppingRepo toppingRepo;

    @Test
    void testGetAllToppings() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(new Topping(1L,"Pepperoni",ToppingType.MEAT));
        toppings.add(new Topping(2L,"Sausage",ToppingType.MEAT));
        toppings.add(new Topping(3L,"Olives",ToppingType.VEGGIE));
        // mock list of toppings
        when(toppingRepo.findAll()).thenReturn(toppings);

    ToppingService toppingService = new ToppingService(toppingRepo);

    List<Topping> result = toppingService.fetchToppings();

    assertEquals(toppings.size(), result.size());
    assertEquals(toppings.get(0).getName(), result.get(0).getName());
    assertEquals(toppings.get(1).getName(), result.get(1).getName());
    assertEquals(toppings.get(2).getName(), result.get(2).getName());
    verify(toppingRepo).findAll();
    }
    @Test
    void testGetToppingById() {
        when(toppingRepo.findById(1L)).thenReturn(java.util.Optional.of(new Topping(1L,"Pepperoni",ToppingType.MEAT)));
        ToppingService toppingService = new ToppingService(toppingRepo);
        Topping topping = toppingService.fetchTopping(1L);
        assertEquals("Pepperoni", topping.getName());
        assertEquals(1L, topping.getId());
        verify(toppingRepo).findById(1L);
    }
    @Test
    void testGetToppingByName() {
        //need a mock topping becuase ids are auto generated
        Topping topping = new Topping(1L,"Pepperoni",ToppingType.MEAT);
        ToppingService toppingService = new ToppingService(toppingRepo);
        when(
            toppingRepo.findByName(topping.getName()
        )).thenReturn(topping);

    // Act
    Topping result = toppingService.fetchTopping(topping.getName());

    // Assert
    assertNotNull(result);
    assertEquals("Pepperoni", result.getName());
    assertEquals(ToppingType.MEAT, result.getType());

    verify(toppingRepo).findByName(topping.getName());    
    }
    @Test
    void testAddTopping() {
        Topping topping = new Topping(1L,"Pepperoni",ToppingType.MEAT);
        when(toppingRepo.save(topping)).thenReturn(topping);
        ToppingService toppingService = new ToppingService(toppingRepo);
        Topping newTopping = toppingService.addTopping(topping);
        assertEquals("Pepperoni", newTopping.getName());
        assertEquals(1L, newTopping.getId());
        verify(toppingRepo).save(topping);

    }
    @Test
    void testUpdateTopping() {
        Topping topping = new Topping(1L,"Pepperoni",ToppingType.MEAT);
        //mock the find by id method
        when(toppingRepo.findById(topping.getId())).thenReturn(java.util.Optional.of(topping));
        //mock the save method
        when(toppingRepo.save(topping)).thenReturn(topping);
        ToppingService toppingService = new ToppingService(toppingRepo);
        Topping updatedTopping = toppingService.updateTopping(topping.getId(),topping);
        assertEquals("Pepperoni", updatedTopping.getName());
        assertEquals(1L, updatedTopping.getId());
        verify(toppingRepo).findById(topping.getId());
        verify(toppingRepo).save(topping);
    }

    @Test
    void testFetchToppingByIdNotFound(){

        when(toppingRepo.findById(99L)).
            thenReturn(Optional.empty());
        
        ToppingService toppingService = new ToppingService(toppingRepo);
        NoSuchElementException exception =  assertThrows(
            NoSuchElementException.class, ()->{
            toppingService.fetchTopping(99L);
        });
        String errorMessage = "Topping not found with id: " + 99L;
        assertEquals(errorMessage, exception.getMessage());

        verify(toppingRepo).findById(99L);
    }

}
