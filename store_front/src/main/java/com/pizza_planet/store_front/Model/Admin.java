package com.pizza_planet.store_front.Model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends Account {
    
    public Admin(String name,String username,String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int adminID;
    public int getAdminID() {
        return adminID;
    }
    @Override
    public String toString() {
        return "Admin [name=" + name + ", username=" + username + ", password=" + password + ", dob=" + dob
                + ", enrollmentDate=" + enrollmentDate + ", adminID=" + adminID + "]";
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.username);
        hash = 29 * hash + Objects.hashCode(this.password);
        hash = 29 * hash + Objects.hashCode(this.dob);
        hash = 29 * hash + Objects.hashCode(this.enrollmentDate);
        hash = 29 * hash + this.adminID;
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
        Admin other = (Admin) obj;
        if (adminID != other.adminID)
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
        else if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        else if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    }

}