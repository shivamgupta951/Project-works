package Account_registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("getUserInfo".equals(action)) {
            String email = request.getParameter("email");
            try {
                String username = User_info.get_username(email);
                request.setAttribute("username", username);
                request.getRequestDispatcher("userInfo.jsp").forward(request, response);
            } catch (Exception e) {
                response.getWriter().println("Error: " + e.getMessage());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String name = request.getParameter("name");
        int phone = Integer.parseInt(request.getParameter("phone"));
        String password = request.getParameter("password");
        String profession = request.getParameter("profession");
        String state = request.getParameter("state");

        try {
            User_info.user_registration(email, dob, name, phone, password, profession, state);
            response.sendRedirect("success.jsp");
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }
    }
}
