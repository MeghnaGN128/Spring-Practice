package com.xworkz.dmart.runner;

import com.xworkz.dmart.entity.ProductEntity;

import javax.persistence.*;

public class ProductRead {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=null;
        EntityManager entityManager=null;
        EntityTransaction entityTransaction=null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");//load,register,create driver
            System.out.println("connection established");
            entityManager = entityManagerFactory.createEntityManager();//DML(inser,delete,update),DQL(select)
            entityTransaction= entityManager.getTransaction();
            entityTransaction.begin();
            ProductEntity productEntity=entityManager.find(ProductEntity.class,1);
            System.out.println(productEntity);
            entityTransaction.commit();
        } catch (PersistenceException e) {
            e.getStackTrace();
        }finally {
            if(entityManagerFactory!=null){
                entityManagerFactory.close();
            }
            if (entityManager!=null){
                entityManager.close();
            }
        }


    }
}
