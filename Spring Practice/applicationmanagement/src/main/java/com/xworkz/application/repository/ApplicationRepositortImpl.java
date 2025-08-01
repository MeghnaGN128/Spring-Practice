package com.xworkz.application.repository;

import com.xworkz.application.entity.ApplicationEntity;

import javax.persistence.*;
import java.util.Optional;

public class ApplicationRepositortImpl implements ApplicationRepository {
    public ApplicationRepositortImpl() {
        System.out.println("running in ApplicationRepositortImpl");
    }

    @Override
    public boolean saveApplication(ApplicationEntity applicationEntity) {
        System.out.println("running in saveApplication");
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityManager.getTransaction().begin();
            entityManager.persist(applicationEntity);
            entityManager.getTransaction().commit();
            System.out.println("Insertion completed");
        } catch (PersistenceException e) {
            e.printStackTrace();
            if (entityTransaction != null) {
                entityTransaction.rollback();
                System.out.println("rollback");
                return false;
            }
        } finally {
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            if (entityManager != null) {
                entityManager.close();

            }
        }
        return true;
    }

    @Override
    public Optional<ApplicationEntity> findById(int id) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        ApplicationEntity applicationEntity = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("x-workz");
            entityManager = entityManagerFactory.createEntityManager();
            applicationEntity = entityManager.find(ApplicationEntity.class, id);
            if (applicationEntity != null) {
                System.out.println("Id is found");
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }finally{
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
        if (entityManager != null) {
            entityManager.close();

        }
    }
        return applicationEntity == null ? Optional.empty() : Optional.of(applicationEntity);
}

@Override
public boolean deleteById(int id) {
    return false;
}

@Override
public boolean updateById(int id, String company) {
    return false;
}

}
