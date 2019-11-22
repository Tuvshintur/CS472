package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.service.FoodService;
import edu.mum.cs.cs472.service.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FoodEditServlet", urlPatterns = "/editFood", description = "FoodEditServlet")
public class FoodEditServlet extends HttpServlet {
    private FoodService foodService;

    public FoodEditServlet() {foodService = new FoodServiceImpl(); }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Food edit working");
        request.setAttribute("food", foodService.getFoodById(Integer.parseInt(request.getParameter("foodID"))));
        request.getRequestDispatcher("food.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Food edit working");
    }
}
