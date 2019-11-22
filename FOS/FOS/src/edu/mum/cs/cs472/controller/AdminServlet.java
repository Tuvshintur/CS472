package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.dao.User;
import edu.mum.cs.cs472.service.FoodService;
import edu.mum.cs.cs472.service.OrderService;
import edu.mum.cs.cs472.service.UserService;
import edu.mum.cs.cs472.service.impl.FoodServiceImpl;
import edu.mum.cs.cs472.service.impl.OrderServiceImpl;
import edu.mum.cs.cs472.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin", description = "AdminServlet")
public class AdminServlet extends HttpServlet {

    private UserService userService;
    private FoodService foodService;
    private OrderService orderService;


    public AdminServlet() {
        foodService = new FoodServiceImpl();
        userService = new UserServiceImpl();
        orderService = new OrderServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userList", userService.getAllUser());
        request.setAttribute("foodList", foodService.getAllFood());
        request.setAttribute("orderList", orderService.getAllOrder());
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}
