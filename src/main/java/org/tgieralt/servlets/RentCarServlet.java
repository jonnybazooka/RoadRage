package org.tgieralt.servlets;

import org.tgieralt.models.Car;
import org.tgieralt.models.dao.CarDAO;
import org.tgieralt.models.dao.impl.CarDaoImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RentCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("Id"));
        CarDAO carDAO = new CarDaoImp();
        Car car = carDAO.findCar(id);
        req.setAttribute("pickedCar", car);
        RequestDispatcher dispatcher = req.getRequestDispatcher("rentCar.jsp");
        dispatcher.forward(req, resp);
    }
}
