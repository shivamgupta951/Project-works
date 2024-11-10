package Premium_Recipies;
import Task_manager.Personalised_recipe_id_generator;
import java.sql.*;
public class Personalised_recipes {
    /* Class to store the personalised recipes with new id only in premium accounts. */
    private static String url = "jdbc:mysql://127.0.0.1:3306/Recipe_manager_system";
    private static String username = "root";
    private static String password = "mysql@2004"; 
    public static void Personalised_recipes_storage(String acc_ids , String recipe_namess , String recipe_ingrediants , String recipe_process,  String original_recipe_id)
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
            String personalised_id = Personalised_recipe_id_generator.Personalised_recipe_id_gen(acc_ids);
            String query = "insert into Personalized_recipes(Recipe_name,Recipe_process,Recipe_ingrediants,personalised_recipe_id,original_recipe_id ,Acc_id) values (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, recipe_namess);
            preparedStatement.setString(2, recipe_process);
            preparedStatement.setString(3, recipe_ingrediants);
            preparedStatement.setString(4, personalised_id);
            preparedStatement.setString(5, original_recipe_id);
            preparedStatement.setString(6, acc_ids);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
