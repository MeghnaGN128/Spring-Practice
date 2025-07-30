package com.xworkz.products.runner;

import com.xworkz.products.entity.PassportEntity;
import javax.persistence.*;

public class PassportCreate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            PassportEntity passport = new PassportEntity();
            passport.setPassportNumber("L1234567");
            passport.setHolderName("Meghna Ninganur");
            passport.setNationality("Indian");
            passport.setExpiryDate("30-12-2032");

            entityManager.persist(passport);
            entityTransaction.commit();
            System.out.println("Passport saved: " + passport);
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in passport create");
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
                System.out.println("Transaction rolled back");
            }
        } finally {
            if (entityManager != null){
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
