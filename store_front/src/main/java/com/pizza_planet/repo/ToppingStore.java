package com.pizza_planet.repo;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pizza_planet.model.Category;
import com.pizza_planet.model.Topping;


public class ToppingStore {
    private final SessionFactory sessionFactory;

    public ToppingStore(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    //list of toppings
    public List<Topping> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT t FROM Topping t", Topping.class).getResultList();
        }
    }
    //single topping
    public Topping findById(Long id){
        try (Session session = sessionFactory.openSession()) {
            return session.get(Topping.class, id);
        }
    }
    //update
    public void update(Topping topping){
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.merge(topping);
            session.getTransaction().commit();
        }
    }
    //delete
    public void delete(Topping topping){
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            session.remove(topping);
            session.getTransaction().commit();
        }
    }
    //filter by category
    public List<Topping> findByCategory(String category){
        // Use a parameterized query to prevent SQL injection
        //map the string category to the enum Category
        Category categoryEnum = Category.valueOf(category.toUpperCase());
        //if the category is not valid, return an empty list
        if (categoryEnum == null) {
            return List.of();
        }
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT t FROM Topping t WHERE t.category = :categoryEnum", Topping.class)
                    .setParameter("categoryEnum", categoryEnum)
                    .getResultList();
        }
    }
    
}