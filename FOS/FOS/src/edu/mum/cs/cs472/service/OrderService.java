package edu.mum.cs.cs472.service;

import edu.mum.cs.cs472.dao.Food;
import edu.mum.cs.cs472.dao.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrder();

    public List<Order> getOrderByUserId(int userId);

    public Order getOrderById(int orderId);
    
    public String addOrder(Order newOrder);

    public String changeStatus(int orderId);
}