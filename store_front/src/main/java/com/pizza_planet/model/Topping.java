
package com.pizza_planet.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "toppings")
public class Topping {
    @Id
    int id;
    public Topping() {
    }
    public Topping(String name, Category category) {
        this.name = name;
        this.category = category;
    }
    //name of the topping
    //must match the name in the database
    @Column(name = "topping_name")
    String name;
    //category of the topping
    @Enumerated(EnumType.STRING)
    Category category;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((category == null) ? 0 : category.hashCode());
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
        Topping other = (Topping) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (category != other.category)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Topping [id=" + id + ", name=" + name + ", category=" + category + "]";
    }
  
    
}
