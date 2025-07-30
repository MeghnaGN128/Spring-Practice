package com.xworkz.products.runner;

import com.xworkz.products.entity.SoapEntity;
import javax.persistence.*;

public class SoapUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            // Find by primary key (update soap with ID 1)
            SoapEntity soapEntity = entityManager.find(SoapEntity.class, 1);
            System.out.println("Before Update: " + soapEntity);

            if (soapEntity != null) {
                // Modify fields
                soapEntity.setFragrance("Mint");
                soapEntity.setPrice(45.0);

                // Merge updated entity
                SoapEntity updatedSoap = entityManager.merge(soapEntity);
                System.out.println("Updated Entity: " + updatedSoap);
                System.out.println("Update successful");
            } else {
                System.out.println("No soap found with ID 1");
            }

            entityTransaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in soap update");
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
