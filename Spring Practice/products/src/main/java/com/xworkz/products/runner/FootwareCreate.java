package com.xworkz.products.runner;

import com.xworkz.products.entity.FootwareEntity;

import javax.persistence.*;

public class FootwareCreate {
    public static void main(String[] args) {
        FootwareEntity footwareEntity = new FootwareEntity();
        footwareEntity.setType("Sneakers");
        footwareEntity.setBrand("Nike");
        footwareEntity.setSize("9");
        footwareEntity.setPrice(4599.99);

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            System.out.println("Connection established");

            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(footwareEntity);
            System.out.println("Inserted: " + footwareEntity);

            entityTransaction.commit();
            System.out.println("Insert success");
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
                System.out.println("Transaction rolled back");
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
