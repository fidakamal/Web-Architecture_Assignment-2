import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ConfirmPurchase extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("Your order is confirmed.");

        HashMap<String, Integer> cart = (HashMap<String, Integer>)request.getSession().getAttribute("cart");
        cart.clear();

        out.println("<form action=\"ViewProduct\" method=\"post\"><button>Go Back to Homepage</button></form>\n");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
