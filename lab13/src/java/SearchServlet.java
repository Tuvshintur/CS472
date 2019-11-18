import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "SearchServlet", urlPatterns = {"/search"}, description = "SearchServlet")
public class SearchServlet extends HttpServlet {

    private DBFacade dbFacade;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("list", this.dbFacade.getPerson(request.getParameter("searchQuery")));

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/SearchValue.jsp");
        rd.forward(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        this.dbFacade = new DBFacade();
    }
}
