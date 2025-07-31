package com.xworkz.products.runner;
import com.xworkz.products.entity.ChocolateEntity;

import javax.persistence.*;

public class ChocolateCreate {
    public static void main(String[] args) {
        ChocolateEntity chocolateEntity = new ChocolateEntity();
        chocolateEntity.setChocolateName("Park");
        chocolateEntity.setCompany("Park Company");
        chocolateEntity.setMfd("18-01-2025");
        chocolateEntity.setPrice(10.00);


        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,create driver
            System.out.println("connection established");
            entityManager = entityManagerFactory.createEntityManager();//DML(inser,delete,update),DQL(select)
            entityTransaction = entityManager.getTransaction();//TCL(commit,rollback,savepoint)

            entityTransaction.begin();// auto comitt=0
            entityManager.persist(chocolateEntity);
            System.out.println(chocolateEntity);
            entityTransaction.commit();//auto commmit=1

            System.out.println("insert success");
        } catch (PersistenceException e) {
            e.printStackTrace();
            entityTransaction.rollback();
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
