package com.xworkz.items.runner;

import com.xworkz.products.entity.PetAdaptionEntity;

import javax.persistence.*;

public class PetAdaptionCreate {
    public static void main(String[] args) {

        PetAdaptionEntity petEntity = new PetAdaptionEntity();
        petEntity.setPetName("Bruno");
        petEntity.setPetType("Dog");
        petEntity.setAdopterName("Meghna Ninganur");
        petEntity.setAdoptionDate("30-07-2025");

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz"); // Load & create EMF
            System.out.println("Connection established");

            entityManager = entityManagerFactory.createEntityManager(); // Create EM
            entityTransaction = entityManager.getTransaction(); // Start TX

            entityTransaction.begin(); // Begin transaction
            entityManager.persist(petEntity); // Insert
            System.out.println(petEntity);
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
