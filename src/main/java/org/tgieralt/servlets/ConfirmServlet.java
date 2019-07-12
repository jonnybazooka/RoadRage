package org.tgieralt.servlets;

import org.tgieralt.authentication.HashFunction;
import org.tgieralt.authentication.UserValidator;
import org.tgieralt.authentication.impl.SHA256;
import org.tgieralt.models.Car;
import org.tgieralt.models.User;
import org.tgieralt.models.dao.CarDAO;
import org.tgieralt.models.dao.RentDAO;
import org.tgieralt.models.dao.UserDAO;
import org.tgieralt.models.dao.impl.CarDAOi;
import org.tgieralt.models.dao.impl.RentDAOi;
import org.tgieralt.models.dao.impl.UserDAOi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class ConfirmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("confirm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashFunction hashFunction = new SHA256();
        LocalDate startDate = LocalDate.parse(req.getParameter("startDate"));
        LocalDate endDate = LocalDate.parse(req.getParameter("endDate"));
        String userEmail = req.getParameter("userEmail");
        String passHash = hashFunction.hashPassword(req.getParameter("userPassword"));
        boolean isUserConfirmed = new UserValidator().validateUser(userEmail, passHash);
        if (!isUserConfirmed) {
            resp.sendRedirect("confirmationError.jsp");
        } else {
            UserDAO userDAO = new UserDAOi();
            User user = userDAO.findUserByEmail(userEmail);
            long carId = Long.parseLong((String)req.getSession().getAttribute("carId"));
            CarDAO carDAO = new CarDAOi();
            Car car = carDAO.findCar(carId);
            RentDAO rentDAO = new RentDAOi();
            rentDAO.rentCar(user, car, startDate, endDate);
            req.setAttribute("car", car);
            req.setAttribute("user", user);
            RequestDispatcher dispatcher = req.getRequestDispatcher("confirmationOK.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
