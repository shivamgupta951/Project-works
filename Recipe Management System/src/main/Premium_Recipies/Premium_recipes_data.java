package Premium_Recipies;
import Task_manager.Recipies_id_generator;
import java.sql.*;
public class Premium_recipes_data {
    /*Class to store the Premium recipes data with their recipe id. */
    private static String url = "jdbc:mysql://127.0.0.1:3306/Recipe_manager_system";
    private static String username = "root";
    private static String password = "mysql@2004"; 
    public static void Premium_recipes_storage(String recipe_name , String recipe_ingrediants , String recipe_process)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try
        {
            Connection connection = DriverManager.getConnection(url, username, password);
            String type = "Premium Version";
            String recipe_id = Recipies_id_generator.generate_id(type);
            String query = "insert into Premium_recipes(Recipe_name,Recipe_process,Recipe_ingrediants,recipe_id) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, recipe_name);
            preparedStatement.setString(2, recipe_process);
            preparedStatement.setString(3, recipe_ingrediants);
            preparedStatement.setString(4, recipe_id);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
