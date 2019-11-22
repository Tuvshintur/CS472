package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.dao.Food;
import edu.mum.cs.cs472.service.FoodService;
import edu.mum.cs.cs472.service.impl.FoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "FoodServlet", urlPatterns = "/food", description = "FoodServlet")
public class FoodServlet extends HttpServlet {
    private FoodService foodService;

    public FoodServlet() {
        foodService = new FoodServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String foodIDstr = request.getParameter("foodID");
        int foodID = (foodIDstr.length() == 0) ? 0 : Integer.parseInt(foodIDstr);
        System.out.println("Food ID : "+ foodIDstr.length());
        String foodName = request.getParameter("foodName");
        String calories = request.getParameter("calories");
        String foodType = request.getParameter("foodType");
        String description = request.getParameter("description");
        String imageId = request.getParameter("image");
        String price = request.getParameter("price");
        System.out.println("["+foodName+","+calories+","+foodType+","+description+","+imageId+","+price+"]");

        Food newFood = new Food(foodID,foodName,Integer.parseInt(calories),description,foodType,Double.parseDouble(price),Integer.parseInt(imageId),"",0,new Date());
        String regResult;
        if(foodIDstr.length() == 0)
            regResult = this.foodService.newFood(newFood);
        else
            regResult = this.foodService.updateFood(newFood);
        if(regResult.equals("SUCCESS"))  {
            System.out.println("Success");
//            request.getRequestDispatcher("admin.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/admin");
        } else {
            System.out.println("Failure");
            request.setAttribute("errMessage", regResult);
            System.out.println(regResult);
            request.getRequestDispatcher("food.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
