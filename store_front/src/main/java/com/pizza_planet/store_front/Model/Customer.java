package com.pizza_planet.store_front.Model;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "customers")
public class Customer extends Account{
    public Customer(String name,String username,String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int customerID;
    List<Order> orders;
    List<Pizza> favoritePizzas;
    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    public List<Pizza> getFavoritePizzas() {
        return favoritePizzas;
    }
    public void setFavoritePizzas(List<Pizza> favoritePizzas) {
        this.favoritePizzas = favoritePizzas;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.username);
        hash = 29 * hash + Objects.hashCode(this.password);
        hash = 29 * hash + Objects.hashCode(this.dob);
        hash = 29 * hash + Objects.hashCode(this.enrollmentDate);
        hash = 29 * hash + this.customerID;
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (customerID != other.customerID)
            return false;
        else if (dob == null) {
            if (other.dob != null)
                return false;
        } else if (!dob.equals(other.dob))
            return false;
        else if (enrollmentDate == null) {
            if (other.enrollmentDate != null)
                return false;
        } else if (!enrollmentDate.equals(other.enrollmentDate))
            return false;
        return true;
    }  

    public int getCustomerID() {
        return customerID;
    }
    @Override
    public String toString() {
        return "Customer [name=" + name + ", username=" + username + ", password=" + password + ", dob=" + dob
                + ", enrollmentDate=" + enrollmentDate + ", customerID=" + customerID + "]";
    }
}