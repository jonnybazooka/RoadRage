package org.tgieralt.models.dao.impl;

import org.tgieralt.models.Car;
import org.tgieralt.models.Rent;
import org.tgieralt.models.User;
import org.tgieralt.models.dao.RentDAO;
import org.tgieralt.persistence.DatabaseProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class RentDaoImp implements RentDAO {
    @Override
    public void rentCar(User user, Car car, LocalDate startDate, LocalDate endDate) {
        EntityManager entityManager = DatabaseProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Rent rent = new Rent();
        car.setAvailableForRent(false);
        rent.setStartDate(startDate);
        rent.setEndDate(endDate);
        user.addRent(rent);
        car.setRent(rent);
        entityManager.persist(rent);
        transaction.commit();
    }

    @Override
    public List<Rent> getAllRents() {
        EntityManager entityManager = DatabaseProvider.getEntityManager();
        Query query = entityManager.createQuery("FROM Rent r");
        return query.getResultList();
    }

    @Override
    public void removeRent(Long id) {
        EntityManager entityManager = DatabaseProvider.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Rent rent = entityManager.find(Rent.class, id);
        transaction.begin();
        rent.getCar().setAvailableForRent(true);
        rent.getCar().setRent(null);
        rent.getUser().removeRent(rent);
        entityManager.remove(rent);
        transaction.commit();
    }
}
