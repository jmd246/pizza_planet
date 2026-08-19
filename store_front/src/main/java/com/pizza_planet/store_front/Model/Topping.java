package com.pizza_planet.store_front.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "toppings")
public class Topping{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    @Column(name = "topping_name", nullable = false, unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private ToppingType type;


        public Topping() {
    }
    public Topping(String name, ToppingType type) {
        this.name = name;
        this.type = type;
    }
    public Topping(Long id, String name, ToppingType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ToppingType getType() {
        return type;
    }
    public void setType(ToppingType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Topping{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
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
        if (type != other.type)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    
}       