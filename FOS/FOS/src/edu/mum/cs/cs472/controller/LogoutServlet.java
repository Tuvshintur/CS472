package edu.mum.cs.cs472.controller;

import edu.mum.cs.cs472.dao.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", urlPatterns = "/logout", description = "LogoutServlet")
public class LogoutServlet extends HttpServlet {

    public LogoutServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        //invalidate the session if exists
        HttpSession session = request.getSession();
        if (session.getAttribute("loggedUser") != null) {
            User loggedUser = (User) session.getAttribute("loggedUser");
            System.out.println(loggedUser.toString());
        }
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/login");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
