package org.tgieralt.models.dao;

import org.tgieralt.models.Car;

import java.util.List;

public interface CarDAO {

    void saveCar(Car car);
    List getCarList();
    Car findCar(long id);
    List<Car> getRentedCarsList();
}
