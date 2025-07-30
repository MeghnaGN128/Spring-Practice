package com.xworkz.products.runner;

import com.xworkz.products.entity.SoapEntity;

import javax.persistence.*;

public class SoapRead {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;

        try {
            factory = Persistence.createEntityManagerFactory("x-workz");
            manager = factory.createEntityManager();

            SoapEntity entity = manager.find(SoapEntity.class, 1);
            System.out.println(entity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null){
                manager.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }
}
