package com.xworkz.dmart.runner;

import com.xworkz.dmart.entity.ProductEntity;
import javax.persistence.*;

public class ProductUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            ProductEntity productEntity = entityManager.find(ProductEntity.class, 1);
            System.out.println(productEntity);

            if (productEntity != null) {
                productEntity.setPrice(60.0);
                productEntity.setProductName("HandWash");
                ProductEntity updatedProd = entityManager.merge(productEntity);

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
