package org.tgieralt.models.dao.impl;

import org.tgieralt.models.User;
import org.tgieralt.models.dao.UserDAO;
import org.tgieralt.persistence.DatabaseProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.servlet.ServletException;

public class UserDaoImp implements UserDAO {
    @Override
    public void registerNewUser(String email, String creditCard, String hashPass) {
        EntityManager entityManager = DatabaseProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        User user = new User(email, creditCard, hashPass);
        entityManager.persist(user);
        transaction.commit();
    }

    @Override
    public User findUserByEmail(String email) throws ServletException {
        EntityManager entityManager = DatabaseProvider.getEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email")
                .setParameter("email", email);
        try {
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            throw new ServletException("User: " + email + " not found in database.");
        }
    }
}
