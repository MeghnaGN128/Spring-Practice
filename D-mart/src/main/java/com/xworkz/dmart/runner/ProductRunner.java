package com.xworkz.dmart.runner;

import com.xworkz.dmart.entity.ProductEntity;

import javax.persistence.*;

public class ProductRunner {
    public static void main(String[] args) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName("RasamPowder");
        productEntity.setCompany("RasamPowder Company");
        productEntity.setMfd("11-01-2025");
        productEntity.setPrice(56.00);



            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,create driver
            System.out.println("connection established");
            EntityManager entityManager = entityManagerFactory.createEntityManager();//DML(inser,delete,update),DQL(select)
            EntityTransaction transaction = entityManager.getTransaction();//TCL(commit,rollback,savepoint)
            transaction.begin();
            entityManager.persist(productEntity);
            transaction.commit();
            System.out.println("insert success");


    }
}

