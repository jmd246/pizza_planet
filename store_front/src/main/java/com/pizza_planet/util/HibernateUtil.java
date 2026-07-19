package com.pizza_planet.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//singleton pattern for session factory
public class HibernateUtil {
    private static SessionFactory sessFactory;
    private static final Logger logger = LogManager.getLogger(HibernateUtil.class);

    public static SessionFactory getSessionFactory() {
        if (sessFactory == null) {
            try {
                //create the session factory from hibernate.cfg.xml
                SessionFactory sessionFactory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();
                sessFactory = sessionFactory;
                return sessFactory;
            } catch (HibernateException e) {
                logger.error("Error occurred while creating session factory", e );
            }
        }
       return sessFactory;
    }

    //close the session factory
    public static void shutdown() {
        if (sessFactory != null) {
            sessFactory.close();
        }
    }
}
