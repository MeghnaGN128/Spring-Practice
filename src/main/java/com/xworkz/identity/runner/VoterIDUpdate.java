package com.xworkz.identity.runner;


import com.xworkz.dmart.entity.VoterIDEntity;

import javax.persistence.*;

public class VoterIDUpdate {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            // Find by primary key (update voter ID with ID 1)
            VoterIDEntity voterEntity = entityManager.find(VoterIDEntity.class, 1);
            System.out.println("Before Update: " + voterEntity);

            if (voterEntity != null) {
                // Modify fields
                voterEntity.setAge(28);
                voterEntity.setVoterNumber("KA7685321");

                // Merge updated entity
                VoterIDEntity updatedVoter = entityManager.merge(voterEntity);
                System.out.println("Updated Entity: " + updatedVoter);
                System.out.println("Update successful");
            } else {
                System.out.println("No Voter ID found with ID 1");
            }

            entityTransaction.commit();
        } catch (PersistenceException e) {
            e.printStackTrace();
            System.out.println("Exception in VoterID update");
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
                System.out.println("Transaction rolled back");
            }
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
}
