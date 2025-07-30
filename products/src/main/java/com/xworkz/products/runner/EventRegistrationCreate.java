package com.xworkz.products.runner;

import com.xworkz.products.entity.EventRegistration;

import javax.persistence.*;
public class EventRegistrationCreate {
    public static void main(String[] args) {
        EventRegistration registration = new EventRegistration();
        registration.setParticipantName("Sneha Reddy");
        registration.setEventName("Java Bootcamp 2025");
        registration.setRegistrationDate("01-08-2025");
        registration.setContactNumber("9876543211");

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            System.out.println("Connection established");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(registration);
            System.out.println("Inserted: " + registration);

            entityTransaction.commit();
            System.out.println("Insert successful");
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
                System.out.println("Transaction rolled back");
            }
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
