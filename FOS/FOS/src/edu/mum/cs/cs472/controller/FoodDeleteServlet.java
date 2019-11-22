package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.service.FoodService;
import edu.mum.cs.cs472.service.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FoodDeleteServlet", urlPatterns = "/deleteFood", description = "FoodEditServlet")
public class FoodDeleteServlet extends HttpServlet {
    private FoodService foodService;

    public FoodDeleteServlet() {foodService = new FoodServiceImpl(); }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodID = request.getParameter("foodID");
        String regResult = this.foodService.deleteFood(Integer.parseInt(foodID));
        if(regResult.equals("SUCCESS"))  {
            response.sendRedirect(request.getContextPath() + "/admin");
        } else {
            System.out.println("Failure");
            request.setAttribute("errMessage", regResult);
            System.out.println(regResult);
            request.setAttribute("food", foodService.getFoodById(Integer.parseInt(foodID)));
            request.getRequestDispatcher("food.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
