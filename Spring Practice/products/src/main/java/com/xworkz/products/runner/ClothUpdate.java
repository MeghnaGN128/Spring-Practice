package com.xworkz.products.runner;
import com.xworkz.products.entity.ClothEntity;

import javax.persistence.*;
public class ClothUpdate {
    public static void main(String[] args) {
    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;
    EntityTransaction entityTransaction = null;

        try {
        entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
        entityManager = entityManagerFactory.createEntityManager();
        entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        ClothEntity clothEntity = entityManager.find(ClothEntity.class, 1); // Fetch by ID
        System.out.println(clothEntity);

        if (clothEntity != null) {
            clothEntity.setPrice(549.99);
            clothEntity.setType("Formal Shirt");
            ClothEntity updatedCloth = entityManager.merge(clothEntity);
            System.out.println("Data Updated");
            System.out.println(updatedCloth);
        }

        entityTransaction.commit();
    } catch (PersistenceException e) {
        e.printStackTrace();
        System.out.println("Exception in cloth update");
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
