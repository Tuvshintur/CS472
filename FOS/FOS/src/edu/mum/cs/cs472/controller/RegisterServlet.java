package edu.mum.cs.cs472.controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.mum.cs.cs472.dao.Role;
import edu.mum.cs.cs472.dao.User;
import edu.mum.cs.cs472.service.UserService;
import edu.mum.cs.cs472.service.impl.UserServiceImpl;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register", description = "RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private UserService userService;

    public RegisterServlet() {
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RegisterServlet: doPost");
        String first_name = request.getParameter("first_name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User newUser = new User();
        newUser.setFirst_name(first_name);
        newUser.setEmail(email);
        newUser.setPassword(password);
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());        
        //newUser.setCreated(dateStr);
        newUser.setRole(Role.client);
        newUser.setStatus(1);
        
        String regResult = this.userService.registerUser(newUser);
        if(regResult.equals("SUCCESS"))  {
            System.out.println("Success");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            System.out.println("Failure");
            request.setAttribute("errMessage", regResult);
            System.out.println(regResult);
            //request.getRequestDispatcher("register").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Register.doGet()");
        request.getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }

}