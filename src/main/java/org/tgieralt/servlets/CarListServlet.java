package org.tgieralt.servlets;

import org.tgieralt.models.Car;
import org.tgieralt.models.dao.CarDAO;
import org.tgieralt.models.dao.impl.CarDaoImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CarListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Car> cars;
        CarDAO carDAO = new CarDaoImp();
        cars = carDAO.getCarList();
        session.setAttribute("carList", cars);

        RequestDispatcher dispatcher = req.getRequestDispatcher("ourCars.jsp");
        dispatcher.forward(req, resp);
    }
}
