package org.tgieralt.models.dao.impl;

import org.tgieralt.models.Car;
import org.tgieralt.models.dao.CarDAO;
import org.tgieralt.persistence.Persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class CarDAOi implements CarDAO {

    @Override
    public void saveCar(Car car) {
        EntityManager entityManager = Persistence.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(car);
        transaction.commit();
    }

    @Override
    public List getCarList() {
        EntityManager entityManager = Persistence.getEntityManager();
        return entityManager.createQuery("SELECT c from Car c").getResultList();
    }

    @Override
    public Car findCar(long id) {
        EntityManager entityManager = Persistence.getEntityManager();
        return entityManager.find(Car.class, id);
    }

    @Override
    public List<Car> getRentedCarsList() {
        EntityManager entityManager = Persistence.getEntityManager();
        return  entityManager.createQuery("SELECT c from Car c WHERE c.isAvailableForRent = false").getResultList();
    }
}
