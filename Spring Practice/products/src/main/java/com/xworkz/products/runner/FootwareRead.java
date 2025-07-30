package com.xworkz.products.runner;

import com.xworkz.products.entity.FootwareEntity;
import javax.persistence.*;

public class FootwareRead {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz"); // load, register, create driver
            System.out.println("connection established");

            entityManager = entityManagerFactory.createEntityManager(); // DML (insert, delete, update), DQL (select)
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            FootwareEntity footwareEntity = entityManager.find(FootwareEntity.class, 1);
            System.out.println(footwareEntity);

            entityTransaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
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
