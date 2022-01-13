import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class Checkout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<form action=\"ConfirmPurchase\">\n" +
                "   Name <input type=\"text\" name=\"Name\">\n" +
                "   Address <input type=\"text\" name=\"Address\">\n" +
                "   Email <input type=\"text\" name=\"Email\">\n" +
                "   Credit Card Info <input type=\"text\" name=\"Credit Card Info\">\n" +
                "    <input type=\"submit\" value=\"Confirm Payment\">\n" +
                "</form>");
    }
}
