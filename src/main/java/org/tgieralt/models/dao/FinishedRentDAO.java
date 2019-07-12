package org.tgieralt.models.dao;

import org.tgieralt.models.FinishedRent;

import java.util.List;

public interface FinishedRentDAO {
    void saveFinishedRent(long rentID, String comments);
    List<FinishedRent> getAllFinishedRents();
}
