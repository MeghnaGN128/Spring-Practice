package com.xworkz.products.runner;

import com.xworkz.products.entity.PetAdaptionEntity;

import javax.persistence.*;

public class PetAdaptionUpdate {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            // Find by primary key (update pet with ID 1)
            PetAdaptionEntity petEntity = entityManager.find(PetAdaptionEntity.class, 1);
            System.out.println("Before Update: " + petEntity);

            if (petEntity != null) {
                // Modify fields
                petEntity.setPetName("Rocky");
                petEntity.setAdoptionDate("01-08-2025");

                // Merge updated entity
                PetAdaptionEntity updatedEntity = entityManager.merge(petEntity);

                System.out.println("Updated Entity: " + updatedEntity);
                System.out.println("Update successful");
            } else {
                System.out.println("No pet found with ID 1");
            }

            entityTransaction.commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in pet update");

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
