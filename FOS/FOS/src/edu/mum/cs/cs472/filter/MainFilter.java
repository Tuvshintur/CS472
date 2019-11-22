package edu.mum.cs.cs472.filter;

import edu.mum.cs.cs472.dao.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "MainFilter", urlPatterns = "/*")
public class MainFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest rq = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = rq.getRequestURI();
        if (path.equals("/FOS/") || path.contains("/login") || path.contains("/register") || path.contains("/logout") || path.contains("/order") || path.contains("/main") || path.contains("/upload") || path.contains("/js/") || path.contains("/css/")) {
            chain.doFilter(request, response);
        } else {
            HttpSession session = rq.getSession();
            if (session.getAttribute("loggedUser") != null) {
                User user = (User) session.getAttribute("loggedUser");
                request.setAttribute("email", user.getEmail());
                chain.doFilter(request, response);
            } else {
                if (path.contains("/admin") || path.contains("/checkout")) {
                    res.sendRedirect(rq.getContextPath() + "/login");
                } else {
                    res.sendRedirect(rq.getContextPath() + "/");
                }
            }
        }

    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
