package com.xworkz.identity.runner;


import com.xworkz.dmart.entity.VoterIDEntity;

import javax.persistence.*;

public class VoterIDCreate {
    public static void main(String[] args) {

        VoterIDEntity entity = new VoterIDEntity();
        entity.setName("Meghna");
        entity.setVoterNumber("KA1234567");
        entity.setGender("Female");
        entity.setAge(25);

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz"); // Load & create EMF
            System.out.println("Connection established");
            entityManager = entityManagerFactory.createEntityManager(); // Create EM
            entityTransaction = entityManager.getTransaction(); // Start TX
            entityTransaction.begin(); // Begin transaction
            entityManager.persist(entity); // Insert
            System.out.println(entity);
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
