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

@WebServlet(name = "ThankyouServlet", urlPatterns = {"/thankyou"}, description = "ThankyouServlet")
public class ThankyouServlet extends HttpServlet {

    int pageCounter;
    String counter;

    public void init() {
        pageCounter = 0;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        counter = request.getAttribute("counter") != null ? request.getAttribute("counter").toString() : "0";
        pageCounter++;

        out.print("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Contact Us</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css\"\n" +
                "          integrity=\"sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M\" crossorigin=\"anonymous\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container\">\n" +
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
                "<div class=\"jumbotron text-center\">\n" +
                "  <h1 class=\"display-3\">Thank You!</h1>\n" +
                "  <p class=\"lead\"><strong>Please check your information</strong> for further instructions on how to complete your submission.</p>\n" +
                "  <hr>\n" +
                "  <p>\n");
        out.println("<div><h2>Name:</h2>".concat(request.getParameter("name")).concat("</div>"));
        out.println("<div><h2>Gender:</h2>".concat(request.getParameter("gender")).concat("</div>"));
        out.println("<div><h2>Category:</h2>".concat(request.getParameter("category")).concat("</div>"));
        out.println("<div><h2>Message:</h2>".concat(request.getParameter("message")).concat("</div>"));
        out.println("<div><h2>Current Date:</h2></div>");

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

        out.println("<div>".concat(df.format(new Date())).concat("</div>"));
        out.println("  </p>\n" +
                "  <p class=\"lead\">\n" +
                "    <a class=\"btn btn-primary btn-sm\" href=\"/lab10/hello\" role=\"button\">Continue to homepage</a>\n" +
                "  </p>\n" +
                "</div>");

        out.println("<div style=\"display:flex;justify-content:space-between;\"><div><h4>Hit on this page:</h4>".concat(pageCounter + "") + " times.</div>" +
                "<div><h4>Hit counter on website:</h4>".concat(counter + "") + " times.</div></div>");

        out.println("</div><footer class=\"page-footer font-small bg-light\">\n" +
                "        <div class=\"footer-copyright text-center py-3\">© 2019 Copyright:\n" +
                "            <a href=\"/\">CS472 Bank ::: WAP</a>\n" +
                "        </div>\n" +
                "    </footer>\n" +
                "</body>\n" +
                "</html>");
    }
}
