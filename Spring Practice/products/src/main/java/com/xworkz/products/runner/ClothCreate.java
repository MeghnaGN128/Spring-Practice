package com.xworkz.products.runner;

import com.xworkz.products.entity.ClothEntity;

import javax.persistence.*;

public class ClothCreate {
    public static void main(String[] args) {
        ClothEntity clothEntity = new ClothEntity();
        clothEntity.setType("T-Shirt");
        clothEntity.setPrice(499.99);
        clothEntity.setBrand("Levis");
        clothEntity.setSize("M");

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            System.out.println("connection established");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(clothEntity);
            System.out.println(clothEntity);
            entityTransaction.commit();
            System.out.println("insert success");
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
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
