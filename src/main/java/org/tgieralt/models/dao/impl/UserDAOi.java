package org.tgieralt.models.dao.impl;

import org.tgieralt.models.User;
import org.tgieralt.models.dao.UserDAO;
import org.tgieralt.persistence.Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class UserDAOi implements UserDAO {
    @Override
    public void registerNewUser(String email, String creditCard, String hashPass) {
        EntityManager entityManager = Persistence.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = new User(email, creditCard, hashPass);
        entityManager.persist(user);
        transaction.commit();
    }

    @Override
    public User findUserByEmail(String email) {
        EntityManager entityManager = Persistence.getEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email")
                .setParameter("email", email);
        return (User) query.getSingleResult();
    }
}
