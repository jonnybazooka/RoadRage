package org.tgieralt.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tgieralt.models.User;
import org.tgieralt.models.dao.UserDAO;
import org.tgieralt.models.dao.impl.UserDaoImp;

import javax.servlet.ServletException;

public class UserValidator {
    private static final Logger logger = LoggerFactory.getLogger(UserValidator.class);

    public boolean validateUser(String email, String passHash) throws ServletException {
        UserDAO userDAO = new UserDaoImp();
        User user = userDAO.findUserByEmail(email);

        if (user == null) {
            return false;
        } else {
            return user.getPassHash().equalsIgnoreCase(passHash);
        }
    }
}
