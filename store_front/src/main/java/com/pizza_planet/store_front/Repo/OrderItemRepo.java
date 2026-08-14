package com.pizza_planet.store_front.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pizza_planet.store_front.Model.OrderItem;
import com.pizza_planet.store_front.Model.Order;

public interface  OrderItemRepo extends JpaRepository<OrderItem, Long> {
    public Order findOrderByOrderId(Long orderId);
}
