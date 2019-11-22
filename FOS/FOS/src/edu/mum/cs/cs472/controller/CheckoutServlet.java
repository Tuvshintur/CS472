package edu.mum.cs.cs472.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.mum.cs.cs472.dao.Food;
import edu.mum.cs.cs472.dao.Item;
import edu.mum.cs.cs472.dao.Order;
import edu.mum.cs.cs472.dao.User;
import edu.mum.cs.cs472.service.OrderService;
import edu.mum.cs.cs472.service.impl.OrderServiceImpl;

@WebServlet(name = "CheckoutServlet", urlPatterns = "/checkout", description = "CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService;

	public CheckoutServlet() {
	    	orderService = new OrderServiceImpl();
	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean show = false;
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") != null) {
			List<Item> orderedItems = (List<Item>) session.getAttribute("cart");
			User currentUser = (User) session.getAttribute("loggedUser");			
			int total = 0;
			for (Item item : orderedItems) {
				total = (int) (total + item.getQuantity() * item.getFood().getPrice());
			}
			System.out.println("Total:" + total);
			Order newOrder = new Order(total, new Date(), 1, currentUser, orderedItems);
			System.out.println("WOW order object" + newOrder.toString());
			String result = this.orderService.addOrder(newOrder);
			if(result.equals("SUCCESS")) {
				show = true;
				request.setAttribute("result", "Order successfully placed.");
				request.setAttribute("show", show);
				if(session.getAttribute("cart") != null) {
					session.removeAttribute("cart");
				}
				request.getRequestDispatcher("index.jsp").forward(request,response);
			}
		} else {
			request.setAttribute("show", show);
			response.sendRedirect(request.getContextPath() + "/");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
