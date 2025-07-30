package com.xworkz.products.runner;

import com.xworkz.products.entity.EventRegistration;

import javax.persistence.*;

public class EventRegistrationRead {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            System.out.println("Connection established");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            EventRegistration registration = entityManager.find(EventRegistration.class, 1); // change ID as needed
            System.out.println(registration);

            entityTransaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
