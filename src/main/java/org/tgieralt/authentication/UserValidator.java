package org.tgieralt.authentication;

import org.tgieralt.models.User;
import org.tgieralt.models.dao.UserDAO;
import org.tgieralt.models.dao.impl.UserDAOi;

public class UserValidator {
    public boolean validateUser(String email, String passHash) {
        UserDAO userDAO = new UserDAOi();
        User user = userDAO.findUserByEmail(email);
        if (user == null) {
            return false;
        } else {
            return user.getPassHash().equalsIgnoreCase(passHash);
        }
    }
}
