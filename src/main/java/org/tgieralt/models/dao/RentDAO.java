package org.tgieralt.models.dao;

import org.tgieralt.models.Car;
import org.tgieralt.models.Rent;
import org.tgieralt.models.User;

import java.time.LocalDate;
import java.util.List;

public interface RentDAO {
    void rentCar(User User, Car car, LocalDate startDate, LocalDate endDate);
    List<Rent> getAllRents();
    void removeRent(Long id);
}
