package com.xworkz.items.runner;

import com.xworkz.products.entity.SoapEntity;

import javax.persistence.*;

public class SoapCreate {
    public static void main(String[] args) {

        SoapEntity soapEntity = new SoapEntity();
        soapEntity.setName("Dove");
        soapEntity.setBrand("Unilever");
        soapEntity.setPrice(45.0);
        soapEntity.setFragrance("Jasmine");

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz"); // Load & create EMF
            System.out.println("Connection established");
            entityManager = entityManagerFactory.createEntityManager(); // Create EM
            entityTransaction = entityManager.getTransaction(); // Start TX
            entityTransaction.begin(); // Begin transaction

            entityManager.persist(soapEntity); // Insert
            System.out.println(soapEntity);

            entityTransaction.commit(); // Commit transaction
            System.out.println("Insert success");

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
