package com.xworkz.products.runner;

import com.xworkz.products.entity.ChocolateEntity;

import javax.persistence.*;

public class ChocolateRead {
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
            ChocolateEntity chocolateEntity=entityManager.find(ChocolateEntity.class,1);
            System.out.println(chocolateEntity);
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
