import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    String username = "fida";
    String password = "fida";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String pw = request.getParameter("password");

        if (name.equals(username) && pw.equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("currentUser", name);

            HashMap<String, Integer> cart = new HashMap<String, Integer>();
            session.setAttribute("cart", cart);


            RequestDispatcher rd = request.getRequestDispatcher("/viewProduct.html");
            rd.forward(request, response);
        } else {
            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
            out.println("<h5>Incorrect username or password!</h5>\n");

            RequestDispatcher rd2 = request.getRequestDispatcher("/login.html");
            rd2.include(request, response);
        }
    }
}
