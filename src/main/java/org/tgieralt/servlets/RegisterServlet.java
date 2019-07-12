package org.tgieralt.servlets;

import org.tgieralt.authentication.HashFunction;
import org.tgieralt.authentication.impl.SHA256;
import org.tgieralt.models.dao.UserDAO;
import org.tgieralt.models.dao.impl.UserDAOi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAOi();
        HashFunction hashFunction = new SHA256();

        String userEmail = req.getParameter("userEmail");
        String userCreditCard = req.getParameter("userCardNumber");
        String passHash= hashFunction.hashPassword(req.getParameter("userPassword"));
        userDAO.registerNewUser(userEmail, userCreditCard, passHash);
        req.setAttribute("userEmail", userEmail);

        RequestDispatcher dispatcher = req.getRequestDispatcher("success.jsp");
        dispatcher.forward(req, resp);
    }
}
