package org.tgieralt.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Persistence {

    private static EntityManagerFactory entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("roadRageMySQL");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    private Persistence() {}

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
