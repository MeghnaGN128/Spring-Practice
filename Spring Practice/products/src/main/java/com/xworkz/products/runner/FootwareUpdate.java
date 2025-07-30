package com.xworkz.products.runner;

import com.xworkz.products.entity.FootwareEntity;
import javax.persistence.*;

public class FootwareUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            FootwareEntity footwareEntity = entityManager.find(FootwareEntity.class, 1);
            System.out.println(footwareEntity);

            if (footwareEntity != null) {
                footwareEntity.setPrice(1500.0);
                footwareEntity.setBrand("Nike");
                FootwareEntity updatedEntity = entityManager.merge(footwareEntity);
                System.out.println("Data Updated");
                System.out.println(updatedEntity);
            }

            entityTransaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in footware update");

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
