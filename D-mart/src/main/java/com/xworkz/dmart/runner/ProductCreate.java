package com.xworkz.dmart.runner;

import com.xworkz.dmart.entity.ProductEntity;

import javax.persistence.*;

public class ProductCreate {
    public static void main(String[] args) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName("Oil");
        productEntity.setCompany("Coconut Company");
        productEntity.setMfd("11-09-2024");
        productEntity.setPrice(45.00);


        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,create driver
            System.out.println("connection established");
            entityManager = entityManagerFactory.createEntityManager();//DML(inser,delete,update),DQL(select)
            entityTransaction = entityManager.getTransaction();//TCL(commit,rollback,savepoint)

            entityTransaction.begin();// auto comitt=0
            entityManager.persist(productEntity);
            System.out.println(productEntity);
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

