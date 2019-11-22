package edu.mum.cs.cs472.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.util.StringUtils;
import edu.mum.cs.cs472.dao.Food;
import edu.mum.cs.cs472.dao.User;
import edu.mum.cs.cs472.service.FoodService;
import edu.mum.cs.cs472.service.impl.FoodServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "IndexServlet", urlPatterns = "/main", description = "IndexServlet")
public class IndexServlet extends HttpServlet {
    private FoodService foodService;
    public IndexServlet() {
        foodService = new FoodServiceImpl();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        String filter = request.getParameter("filter");
        List<Food> foodList = null;

        if(filter.equals("all")) {
            foodList = foodService.getAllFood();
        } else {
            foodList = foodService.getFoodByType(filter);
        }

        String json = "[]";

        if(foodList.size() > 0) {
            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(foodList);
        }

        PrintWriter out = response.getWriter();
        out.println(json);
    }
}
