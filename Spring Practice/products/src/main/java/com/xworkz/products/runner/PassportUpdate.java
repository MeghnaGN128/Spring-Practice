package com.xworkz.products.runner;

import com.xworkz.products.entity.PassportEntity;
import javax.persistence.*;

public class PassportUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            PassportEntity passport = entityManager.find(PassportEntity.class, 1);
            System.out.println("Before Update: " + passport);

            if (passport != null) {
                passport.setHolderName("Meghna N.");
                passport.setExpiryDate("31-12-2035");
                PassportEntity updated = entityManager.merge(passport);
                System.out.println("Updated Passport: " + updated);
            }

            entityTransaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in passport update");
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