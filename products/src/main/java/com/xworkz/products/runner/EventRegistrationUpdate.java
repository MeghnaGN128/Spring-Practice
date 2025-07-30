package com.xworkz.products.runner;

import com.xworkz.products.entity.EventRegistration;
import javax.persistence.*;

public class EventRegistrationUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            EventRegistration registration = entityManager.find(EventRegistration.class, 1);
            System.out.println(registration);

            if (registration != null) {
                registration.setParticipantName("Rohit Kumar");
                registration.setEventName("Code Hackathon 2025");
                registration.setRegistrationDate("30-07-2025");
                registration.setContactNumber("9988776655");

                EventRegistration updatedRegistration = entityManager.merge(registration);
                System.out.println("Event Registration Updated");
                System.out.println(updatedRegistration);
            }

            entityTransaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in EventRegistration update");

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
