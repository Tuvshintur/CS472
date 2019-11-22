package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.dao.User;
import edu.mum.cs.cs472.service.impl.UserServiceImpl;
import edu.mum.cs.cs472.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login", description = "LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;

    public LoginServlet() {
        userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = userService.login(email, password);

        if (user != null && user.getHastUserId()) {
            HttpSession session = request.getSession();
            session.setAttribute("loggedUser", user);
            //using cookie for check is logged user
            Cookie loginCookie = new Cookie("email", email);
            loginCookie.setMaxAge(30 * 60);
            response.addCookie(loginCookie);
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            response.sendRedirect(request.getContextPath() + "/login?errorMsg=E-mail or password is incorrect");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        request.setAttribute("errorMsg", request.getParameter("errorMsg"));
        rd.forward(request, response);
    }
}
