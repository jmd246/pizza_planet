package com.pizza_planet.repo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pizza_planet.model.Pizza;

public class PizzaStore {
    private final SessionFactory sessionFactory;

    public PizzaStore(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    //list all pizzas
    public List<Pizza> findAll() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT p FROM Pizza p";
            return session.createQuery(hql, Pizza.class).getResultList();   
        }
    }
    //find by name
    public Pizza findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT p FROM Pizza p WHERE p.name = :name";
            return session.createQuery(hql, Pizza.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }
    //find by id
    public Pizza findById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Pizza.class, id);
        }
    }

    

}
