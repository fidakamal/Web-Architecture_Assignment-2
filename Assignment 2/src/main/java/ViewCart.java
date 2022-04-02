import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ViewCart extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Integer> cart = (HashMap<String, Integer>)request.getSession().getAttribute("cart");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String incrementItem = request.getParameter("increment");
        String decrementItem = request.getParameter("decrement");
        String removeItem = request.getParameter("remove");

        if(incrementItem != null)
            cart.put(incrementItem, cart.get(incrementItem) + 1);

        if(decrementItem != null && cart.get(decrementItem) != 1)
            cart.put(decrementItem, cart.get(decrementItem) - 1);

        if(removeItem != null)
            cart.remove(removeItem);

        if(cart.size() == 0)
            out.println("Your cart is empty.");

        out.println("<form action=\"ViewProduct\" method=\"post\" style=\"display:inline-block\"><button>Homepage</button></form>");
        out.println("<form action=\"Checkout\" method=\"post\" style=\"display:inline-block\"><button>Checkout</button></form><br><br>\n");

        for(String item: cart.keySet())
        {
            out.println(item + " Quantity: " + cart.get(item));
            out.println("<form action=\"ViewCart\">\n" +
                    "    <button name=\"decrement\" value=\"" + item + "\">-</button>" +
                    "    <button name=\"increment\" value=\"" + item + "\">+</button>" +
                    "    <button name=\"remove\" value=\"" + item + "\">Remove Item</button>" +
                    "</form><br><br>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
