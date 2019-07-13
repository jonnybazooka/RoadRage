package org.tgieralt.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DatabaseProvider {

    private static EntityManagerFactory entityManagerFactory = javax.persistence.Persistence.createEntityManagerFactory("roadRageMySQL");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();

    private DatabaseProvider() {}

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
