package com.pizza_planet.store_front.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int quantity;
    @ManyToOne
    @JoinColumn(name = "pizza_id")
    Pizza pizza;

    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    public OrderItem(int quantity, Pizza pizza) {
        this.quantity = quantity;
        this.pizza = pizza;
    }
    public OrderItem(){}
    public Long getId() {
        return id;
    }
  
    @Override
    public String toString() {
        return "OrderItem [id=" + id + ", quantity=" + quantity + ", pizza=" + pizza + ", order=" + order + "]";
    }
    public int getQuantity() {
        return quantity;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + quantity;
        result = prime * result + ((pizza == null) ? 0 : pizza.hashCode());
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        if (quantity != other.quantity)
            return false;
        if (pizza == null) {
            if (other.pizza != null)
                return false;
        } else if (!pizza.equals(other.pizza))
            return false;
        if (order == null) {
            if (other.order != null)
                return false;
        } else if (!order.equals(other.order))
            return false;
        return true;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Pizza getPizza() {
        return pizza;
    }
    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
