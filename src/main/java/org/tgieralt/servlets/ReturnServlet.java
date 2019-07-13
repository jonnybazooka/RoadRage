package org.tgieralt.servlets;

import org.tgieralt.models.Car;
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
import java.util.List;

public class ReturnServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDAO carDAO = new CarDaoImp();
        List<Car> rentedCars = carDAO.getRentedCarsList();
        req.setAttribute("rentedCars", rentedCars);
        RequestDispatcher dispatcher = req.getRequestDispatcher("return.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long rentId = Long.parseLong(req.getParameter("carSelect"));
        String comments = req.getParameter("comments");
        FinishedRentDAO finishedRentDAO = new FinishedRentDaoImp();
        RentDAO rentDAO = new RentDaoImp();
        finishedRentDAO.saveFinishedRent(rentId, comments);
        rentDAO.removeRent(rentId);
        resp.sendRedirect("return");
    }
}
