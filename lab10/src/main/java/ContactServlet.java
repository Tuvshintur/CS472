import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ContactServlet", urlPatterns = {"/contact"}, description = "ContactServlet")
public class ContactServlet extends HttpServlet {

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
        pageCounter++;
        counter = request.getAttribute("counter") != null ? request.getAttribute("counter").toString() : "0";

        request.setAttribute("pageCounter", pageCounter);
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
                "<div class=\"container\">\n" +
                "    <h1>Contact Us</h1>\n" +
                "    <div class=\"container\">\n" +
                "    <div style=\"color:red;\">" +
                (request.getAttribute("msg") != null ? request.getAttribute("msg").toString() : "") +
                "</div>" +
                "        <form name=\"contactus\" method=\"get\" action=\"/lab10/validation\">\n" +
                "            <fieldset>\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label for=\"name\">Name</label>\n" +
                "                    <input type=\"text\" class=\"form-control\" id=\"name\" aria-describedby=\"nameHelp\" name=\"name\" required>\n" +
                "                    <small id=\"nameHelp\" class=\"form-text text-muted\">Please enter your full name.</small>\n" +
                "                </div>\n" +
                "                <div class=\"form-group\">\n" +
                "                    <div class=\"form-check-inline\">\n" +
                "                        <label class=\"form-check-label\">\n" +
                "                            <input type=\"radio\" class=\"form-check-input\" name=\"gender\" value=\"Male\" checked>Male\n" +
                "                        </label>\n" +
                "                    </div>\n" +
                "                    <div class=\"form-check-inline\">\n" +
                "                        <label class=\"form-check-label\">\n" +
                "                            <input type=\"radio\" class=\"form-check-input\" name=\"gender\" value=\"Female\">Female\n" +
                "                        </label>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label for=\"category\">Category</label>\n" +
                "                    <select class=\"form-control\" id=\"category\" name=\"category\" required>\n" +
                "                        <option value=\"\">Select Category</option>\n" +
                "                        <option value=\"Feedback\">Feedback</option>\n" +
                "                        <option value=\"Inquiry\">Inquiry</option>\n" +
                "                        <option value=\"Complaint\">Complaint</option>\n" +
                "                    </select>\n" +
                "                </div>\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label for=\"message\">Message</label>\n" +
                "                    <textarea class=\"form-control\" rows=\"5\" id=\"message\" name=\"message\"></textarea>\n" +
                "                </div>\n" +
                "                <button id=\"btnSubmit\" type=\"submit\" class=\"btn btn-primary\">Submit</button>\n" +
                "            </fieldset>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "<div style=\"display:flex;justify-content:space-between;\"><div><h4>Hit on this page:</h4>".concat(pageCounter + "") + " times.</div>" +
                "<div><h4>Hit counter on website:</h4>".concat(counter + "") + " times.</div></div>" +
                "</div>\n" +
                "    <footer class=\"page-footer font-small bg-light\">\n" +
                "        <div class=\"footer-copyright text-center py-3\">© 2019 Copyright:\n" +
                "            <a href=\"/\">CS472 Bank ::: WAP</a>\n" +
                "        </div>\n" +
                "    </footer>\n" +
                "</body>\n" +
                "</html>");

    }
}
