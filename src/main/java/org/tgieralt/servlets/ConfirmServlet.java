package org.tgieralt.servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tgieralt.authentication.HashFunction;
import org.tgieralt.authentication.UserValidator;
import org.tgieralt.authentication.impl.SHA256;
import org.tgieralt.models.Car;
import org.tgieralt.models.User;
import org.tgieralt.models.dao.CarDAO;
import org.tgieralt.models.dao.RentDAO;
import org.tgieralt.models.dao.UserDAO;
import org.tgieralt.models.dao.impl.CarDaoImp;
import org.tgieralt.models.dao.impl.RentDaoImp;
import org.tgieralt.models.dao.impl.UserDaoImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ConfirmServlet extends HttpServlet {
    private Logger logger = LoggerFactory.getLogger(ConfirmServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("confirm.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashFunction hashFunction = new SHA256();
        LocalDate startDate;
        LocalDate endDate;
        try {
            startDate = LocalDate.parse(req.getParameter("startDate"));
            endDate = LocalDate.parse(req.getParameter("endDate"));
        } catch (DateTimeParseException e) {
            logger.info("startDate or endDate missing");
            throw new ServletException("startDate or endDate missing");
        }
        String userEmail = req.getParameter("userEmail");
        String passHash = hashFunction.hashPassword(req.getParameter("userPassword"));
        boolean isUserConfirmed = new UserValidator().validateUser(userEmail, passHash);
        if (!isUserConfirmed) {
            logger.info("User: " + userEmail + " tried to log-in, but was not recognized.");
            throw new ServletException("Password for user: " + userEmail + " was not recognized.");
        } else {
            UserDAO userDAO = new UserDaoImp();
            User user = userDAO.findUserByEmail(userEmail);
            long carId = Long.parseLong((String)req.getSession().getAttribute("carId"));
            CarDAO carDAO = new CarDaoImp();
            Car car = carDAO.findCar(carId);
            RentDAO rentDAO = new RentDaoImp();
            rentDAO.rentCar(user, car, startDate, endDate);
            req.setAttribute("car", car);
            req.setAttribute("user", user);
            RequestDispatcher dispatcher = req.getRequestDispatcher("confirmationOK.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
