import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class ViewProduct extends HttpServlet {
    int totalItem = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HashMap<String, Integer> cart = (HashMap<String, Integer>)request.getSession().getAttribute("cart");
        if(request.getParameter("item") != null) {
            int itemIdx = Integer.parseInt(request.getParameter("item"));
            boolean itemExists = false;

            for (String item : cart.keySet()) {
                if (item.equals("Item " + itemIdx)) {
                    cart.put(item, cart.get(item) + 1);
                    totalItem++;
                    itemExists = true;
                }
            }

            if (itemExists == false) {
                cart.put("Item " + itemIdx, 1);
                totalItem++;
            }
        }


        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h4>" + totalItem + " Items in cart</h4>");

        RequestDispatcher rd = request.getRequestDispatcher("/viewProduct.html");
        rd.include(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
