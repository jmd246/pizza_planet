package com.pizza_planet;
import org.hibernate.SessionFactory;

import com.pizza_planet.model.Topping;
import com.pizza_planet.repo.ToppingStore;
import com.pizza_planet.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        ToppingStore toppingStore = new ToppingStore(sessionFactory );
        for (Topping topping : toppingStore.findAll()) {
            System.out.println(topping);
        }
    }
}