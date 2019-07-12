package org.tgieralt.models.dao;

import org.tgieralt.models.User;

import javax.servlet.ServletException;

public interface UserDAO {
    void registerNewUser(String email, String creditCard, String hashPass);
    User findUserByEmail(String email) throws ServletException;
}
