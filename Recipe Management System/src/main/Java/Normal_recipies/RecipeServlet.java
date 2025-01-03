package Normal_recipies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RecipeServlet")
public class RecipeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String ingredients = request.getParameter("ingredients");
        String process = request.getParameter("process");

        try {
            Normal_recipes_data.Normal_recipes_storage(name, ingredients, process);
            response.sendRedirect("recipeSuccess.jsp");
        } catch (Exception e) {
            response.getWriter().println("Error saving recipe: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Future functionality for retrieving recipes
        response.getWriter().println("GET request for RecipeServlet");
    }
}
