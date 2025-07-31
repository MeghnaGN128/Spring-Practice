package com.xworkz.field.runner;

import com.xworkz.products.entity.PassportEntity;
import javax.persistence.*;

public class PassportRead {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();

            PassportEntity entity = entityManager.find(PassportEntity.class, 1);
            System.out.println("Passport details: " + entity);
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in passport read");
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
