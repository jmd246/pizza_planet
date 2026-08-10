package com.pizza_planet.store_front.Model;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderID;
    //can have multiple pizzas in an order
    private List<Pizza> pizzas;
    //order date
    private Date orderDate;
    //status of order (pending, in progress, completed, cancelled)
    private OrderStatus status;
    //total price
    public List<Pizza> getPizzas() {
        return pizzas;
    }
    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public Order(List<Pizza> pizzas, Date orderDate, OrderStatus status) {
        this.pizzas = pizzas;
        this.orderDate = orderDate;
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.pizzas);
        hash = 29 * hash + Objects.hashCode(this.orderDate);
        hash = 29 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (!Objects.equals(this.pizzas, other.pizzas)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        return this.status == other.status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order{");
        sb.append("orderID=").append(orderID);
        sb.append(", pizzas=").append(pizzas);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }


    
    
}
