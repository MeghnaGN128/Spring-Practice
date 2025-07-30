package com.xworkz.products.runner;

import com.xworkz.products.entity.BakeryEntity;

import javax.persistence.*;

public class BakeryCreate {
    public static void main(String[] args) {
        BakeryEntity bakeryEntity = new BakeryEntity();
        bakeryEntity.setSweetName("Rasgulla");
        bakeryEntity.setCompany("Haladirams Company");
        bakeryEntity.setMfd("15-01-2025");
        bakeryEntity.setPrice(80.00);


        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,create driver
            System.out.println("connection established");
            entityManager = entityManagerFactory.createEntityManager();//DML(inser,delete,update),DQL(select)
            entityTransaction = entityManager.getTransaction();//TCL(commit,rollback,savepoint)

            entityTransaction.begin();// auto comitt=0
            entityManager.persist(bakeryEntity);
            System.out.println(bakeryEntity);
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
