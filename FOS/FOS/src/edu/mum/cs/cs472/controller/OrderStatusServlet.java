package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.service.OrderService;
import edu.mum.cs.cs472.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "OrderStatusServlet", urlPatterns = "/orderStatus", description = "OrderStatusServlet")
public class OrderStatusServlet extends HttpServlet {
    private OrderService orderService;

    public OrderStatusServlet() { orderService = new OrderServiceImpl();}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Status Working");
        String orderId = request.getParameter("orderId");
        String regResult = this.orderService.changeStatus(Integer.parseInt(orderId));
        System.out.println(regResult);
        response.setContentType("text/plain");
        PrintWriter writer = response.getWriter();
        writer.print("okay");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
