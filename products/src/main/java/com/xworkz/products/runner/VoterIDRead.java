package com.xworkz.products.runner;

import com.xworkz.products.entity.VoterIDEntity;

import javax.persistence.*;

public class VoterIDRead {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;

        try {
            factory = Persistence.createEntityManagerFactory("x-workz");
            manager = factory.createEntityManager();

            VoterIDEntity entity = manager.find(VoterIDEntity.class, 1);
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
