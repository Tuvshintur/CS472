import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
