package Premium_Recipies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/PremiumRecipeServlet")
public class PremiumRecipeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String ingredients = request.getParameter("ingredients");
        String process = request.getParameter("process");

        try {
            Premium_recipes_data.Premium_recipes_storage(name, ingredients, process);
            response.sendRedirect("premiumRecipeSuccess.jsp");
        } catch (Exception e) {
            response.getWriter().println("Error saving premium recipe: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Future functionality for retrieving premium recipes
        response.getWriter().println("GET request for PremiumRecipeServlet");
    }
}
