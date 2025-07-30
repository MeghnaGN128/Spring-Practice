package com.xworkz.dmart.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;


import static javax.persistence.Persistence.createEntityManagerFactory;

public class ProductRunner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= createEntityManagerFactory("x-workz");
        EntityManager entityManager=   entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=

    }
}
