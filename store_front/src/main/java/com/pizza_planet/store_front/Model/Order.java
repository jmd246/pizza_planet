package com.pizza_planet.store_front.Model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;

    // An order can contain multiple pizzas,
    // and a pizza can belong to multiple orders.
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
        name = "order_pizzas",
        joinColumns = @JoinColumn(name = "order_id"),
        inverseJoinColumns = @JoinColumn(name = "pizza_id")
    )
    private List<Pizza> pizzas;

    // Order date
    private Date orderDate;

    // Status of order
    private OrderStatus status;

    // Customer who placed the order
    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    public Order() {
    }

    public Order(List<Pizza> pizzas, Date orderDate, OrderStatus status) {
        this.pizzas = pizzas;
        this.orderDate = orderDate;
        this.status = status;
    }

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

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

        if (obj == null || getClass() != obj.getClass()) {
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
        return "Order{" +
                "orderID=" + orderID +
                ", pizzas=" + pizzas +
                ", orderDate=" + orderDate +
                ", status=" + status +
                '}';
    }
}
