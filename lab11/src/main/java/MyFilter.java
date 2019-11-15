import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "Filter1")
public class MyFilter implements Filter {

    private int count;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        count++;
        System.out.println("Hit Counter: " + count);
        request.setAttribute("counter", count);
        chain.doFilter(request, response);
    }

    public void init(FilterConfig fConfig) throws ServletException {
        // Get init parameter
        count = 0;

        //Print the init parameter
        System.out.println("Hit Counter: " + count);
    }
}
