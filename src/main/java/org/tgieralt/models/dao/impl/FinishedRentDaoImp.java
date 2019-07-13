package org.tgieralt.models.dao.impl;

import org.tgieralt.models.Car;
import org.tgieralt.models.FinishedRent;
import org.tgieralt.models.Rent;
import org.tgieralt.models.User;
import org.tgieralt.models.dao.FinishedRentDAO;
import org.tgieralt.persistence.DatabaseProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class FinishedRentDaoImp implements FinishedRentDAO {
    @Override
    public void saveFinishedRent(long rentId, String comments) {
        EntityManager entityManager = DatabaseProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        Rent rent = entityManager.find(Rent.class, rentId);
        Car car = rent.getCar();
        User user = rent.getUser();
        FinishedRent finishedRent = new FinishedRent(car.getProducer()
                , car.getModel()
                , user.getEmail()
                , rent.getStartDate()
                , rent.getEndDate()
                , comments);
        transaction.begin();
        entityManager.persist(finishedRent);
        transaction.commit();
    }

    @Override
    public List<FinishedRent> getAllFinishedRents() {
        EntityManager entityManager = DatabaseProvider.getEntityManager();
        return (List<FinishedRent>)entityManager.createQuery("FROM FinishedRent").getResultList();
    }
}
