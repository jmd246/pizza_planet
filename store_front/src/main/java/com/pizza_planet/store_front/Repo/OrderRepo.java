package com.pizza_planet.store_front.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizza_planet.store_front.Model.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
    
}
