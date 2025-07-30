package com.xworkz.products.runner;

import com.xworkz.products.entity.BakeryEntity;

import javax.persistence.*;

public class BakeryRead {
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
            BakeryEntity bakeryEntity=entityManager.find(BakeryEntity.class,1);
            System.out.println(bakeryEntity);
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
