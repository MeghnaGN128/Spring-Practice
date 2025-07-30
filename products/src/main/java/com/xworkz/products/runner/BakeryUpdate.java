package com.xworkz.products.runner;

import com.xworkz.products.entity.BakeryEntity;

import javax.persistence.*;

public class BakeryUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            BakeryEntity bakeryEntity = entityManager.find(BakeryEntity.class,1);
            System.out.println(bakeryEntity);

            if (bakeryEntity != null) {
                bakeryEntity.setPrice(60.0);
                bakeryEntity.setSweetName("Gulab jamun");
                BakeryEntity updatedProd = entityManager.merge(bakeryEntity);

                System.out.println("Data Updated");
                System.out.println(updatedProd);
            }

            entityTransaction.commit();

        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in product update");

            // Rollback if error
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
