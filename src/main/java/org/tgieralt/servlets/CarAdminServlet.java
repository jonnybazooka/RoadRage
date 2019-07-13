package org.tgieralt.servlets;

import org.tgieralt.models.Car;
import org.tgieralt.models.FinishedRent;
import org.tgieralt.models.Rent;
import org.tgieralt.models.dao.CarDAO;
import org.tgieralt.models.dao.FinishedRentDAO;
import org.tgieralt.models.dao.RentDAO;
import org.tgieralt.models.dao.impl.CarDaoImp;
import org.tgieralt.models.dao.impl.FinishedRentDaoImp;
import org.tgieralt.models.dao.impl.RentDaoImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CarAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RentDAO rentDAO = new RentDaoImp();
        FinishedRentDAO finishedRentDAO = new FinishedRentDaoImp();
        List<Rent> allRents = rentDAO.getAllRents();
        List<FinishedRent> finishedRents = finishedRentDAO.getAllFinishedRents();
        req.setAttribute("rentList", allRents);
        req.setAttribute("finishedRents", finishedRents);

        RequestDispatcher dispatcher = req.getRequestDispatcher("adminPanel.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String carProducer = req.getParameter("carProducer");
        String carModel = req.getParameter("carModel");
        LocalDate prodDate = LocalDate.parse(req.getParameter("carProdDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Car car = new Car(carProducer, carModel, prodDate, true);
        CarDAO carDAO = new CarDaoImp();
        carDAO.saveCar(car);

        resp.sendRedirect("admin");
    }
}
