import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "ContactFormServlet", urlPatterns = {"/contact-form"}, description = "ContactFormServlet")
public class ContactFormServlet extends HttpServlet {
    private int hitCount;

    private String jspName = "/WEB-INF/views/contact-form.jsp";

    public ContactFormServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        hitCount++;
        request.setAttribute("hitCount", hitCount);
        request.setAttribute("now", LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy")));

        RequestDispatcher rd = request.getRequestDispatcher(jspName);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
