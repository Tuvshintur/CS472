import com.sun.deploy.util.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
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

public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>HelloServlet</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\"\n" +
                "        integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\" crossorigin=\"anonymous\">\n" +
                "      <script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "    <div class=\" container\">\n" +
                "<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n" +
                "  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarTogglerDemo03\" aria-controls=\"navbarTogglerDemo03\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                "    <span class=\"navbar-toggler-icon\"></span>\n" +
                "  </button>\n" +
                "  <a class=\"navbar-brand\" href=\"/lab10/hello\">LAB 10</a>\n" +
                "  <div class=\"collapse navbar-collapse\" id=\"navbarTogglerDemo03\">\n" +
                "    <ul class=\"navbar-nav mr-auto mt-2 mt-lg-0\">\n" +
                "      <li class=\"nav-item active\">\n" +
                "        <a class=\"nav-link\" href=\"/lab10/contact\">Contact Us <span class=\"sr-only\">(current)</span></a>\n" +
                "      </li>\n" +
                "    </ul>\n" +
                "    <form class=\"form-inline my-2 my-lg-0\">\n" +
                "      <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\n" +
                "      <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Search</button>\n" +
                "    </form>\n" +
                "  </div>\n" +
                "</nav>" +
                "    <footer class=\"page-footer font-small bg-light\">\n" +
                "        <div class=\"footer-copyright text-center py-3\">© 2019 Copyright:\n" +
                "            <a href=\"/\">CS472 Bank ::: WAP</a>\n" +
                "        </div>\n" +
                "    </footer>\n" +
                "</body>\n" +
                "\n" +
                "</html>");
    }
}
