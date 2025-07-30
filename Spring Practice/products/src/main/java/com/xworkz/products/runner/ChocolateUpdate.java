package com.xworkz.products.runner;

import com.xworkz.products.entity.ChocolateEntity;

import javax.persistence.*;

public class ChocolateUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            ChocolateEntity chocolateEntity = entityManager.find(ChocolateEntity.class,1);
            System.out.println(chocolateEntity);

            if (chocolateEntity != null) {
                chocolateEntity.setPrice(500.0);
                chocolateEntity.setChocolateName("Dairymilk");
                ChocolateEntity updatedProd = entityManager.merge(chocolateEntity);

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
