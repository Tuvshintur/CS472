package edu.mum.cs.cs472.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.mum.cs.cs472.dao.Food;
import edu.mum.cs.cs472.dao.Item;
import edu.mum.cs.cs472.service.FoodService;
import edu.mum.cs.cs472.service.impl.FoodServiceImpl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet(name = "CartServlet", urlPatterns = "/order", description = "CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FoodService foodService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        this.foodService = new FoodServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String id = request.getParameter("id");
		int quantity = 1;
		HttpSession session = request.getSession();	
		switch (action) {
			case "add":				
				if(session.getAttribute("cart")==null){
					List<Item> cart = new ArrayList<Item>();				
					cart.add(new Item(this.foodService.getFoodByFoodId(Integer.parseInt(id)), quantity));
					session.setAttribute("cart", cart);
				}else{
					List<Item> cart = (List<Item>) session.getAttribute("cart");
					int index = isExisting(Integer.parseInt(id), cart);
					if(index==-1) {
						Food tmpFood = this.foodService.getFoodByFoodId(Integer.parseInt(id));
						if(tmpFood!=null)
							cart.add(new Item(tmpFood, quantity));						
					}else {
						quantity = cart.get(index).getQuantity()+1;
						cart.get(index).setQuantity(quantity);
					}
					session.setAttribute("cart", cart);
				}				
				break;
			case "delete":
				if(session.getAttribute("cart")!=null){
					List<Item> cart = (List<Item>) session.getAttribute("cart");
					int index = isExisting(Integer.parseInt(id), cart);
					if(index!=-1)
						cart.remove(index);
				}
				break;
			default:
				break;
		}
		response.setContentType("text/plain");
		HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response) {
            private final StringWriter sw = new StringWriter();

            @Override
            public PrintWriter getWriter() throws IOException {
                return new PrintWriter(sw);
            }

            @Override
            public String toString() {
                return sw.toString();
            }
        };
        request.getRequestDispatcher("cart.jsp").include(request, responseWrapper);
        String content = responseWrapper.toString();
        System.out.println("Output : " + content);
        response.getWriter().write(content);
	}

	private int isExisting(int id, List<Item> cart) {
		for(int i=0; i<cart.size(); i++) {
			if(cart.get(i).getFood()!=null && cart.get(i).getFood().getFoodId()==id)
				return i;
		}
		return -1;		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}

}
