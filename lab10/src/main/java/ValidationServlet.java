import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ValidationServlet", urlPatterns = {"/validation"}, description = "ValidationServlet")
public class ValidationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = "";
        if (StringUtils.isBlank(request.getParameter("name"))) {
            msg += "name is missing<br/>";
        }
        if (StringUtils.isBlank(request.getParameter("gender"))) {
            msg += "gender is missing<br/>";
        }
        if (StringUtils.isBlank(request.getParameter("category"))) {
            msg += "category is missing<br/>";
        }
        if (StringUtils.isBlank(request.getParameter("message"))) {
            msg += "message is missing<br/>";
        }
        if (StringUtils.isNotBlank(msg)) {
            RequestDispatcher view = request.getRequestDispatcher("/contact");
            request.setAttribute("msg", msg);
            view.forward(request, response);
        } else {
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            String category = request.getParameter("category");
            String message = request.getParameter("message");
            response.sendRedirect(request.getContextPath() + "/thankyou?name=" + name + "&gender=" + gender + "&category=" + category + "&message=" + message);
        }
    }
}
