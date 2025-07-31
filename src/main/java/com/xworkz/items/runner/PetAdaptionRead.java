package com.xworkz.items.runner;

import com.xworkz.products.entity.PetAdaptionEntity;

import javax.persistence.*;

public class PetAdaptionRead {
    public static void main(String[] args) {
        EntityManagerFactory factory = null;
        EntityManager manager = null;

        try {
            factory = Persistence.createEntityManagerFactory("x-workz");
            manager = factory.createEntityManager();

            PetAdaptionEntity entity = manager.find(PetAdaptionEntity.class, 1);
            System.out.println(entity);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null) {
                manager.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }
}
