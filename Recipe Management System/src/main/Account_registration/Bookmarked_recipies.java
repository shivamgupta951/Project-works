package Account_registration;
import java.sql.*;
public class Bookmarked_recipies {
    /*Classs is created to store the bookmarked recipies with user id and recipes id */
    private static String url = "jdbc:mysql://127.0.0.1:3306/Recipe_manager_system";
    private static String username = "root";
    private static String password = "mysql@2004"; 
    public static void Bookmark(String acc_id , String recipe_id , String name)
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
            String type = "";
            if (recipe_id.charAt(0)=='N' && recipe_id.charAt(1)=='V' && recipe_id.charAt(2)=='R') {
                type=type+"NVR";
            }
            else
            {
                type=type+"PVR";
            }
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "insert into bookmarked_recipies_data(Acc_id,Recipes_id,Recipe_type,Recipe_name) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,acc_id);
            preparedStatement.setString(2,recipe_id);
            preparedStatement.setString(3,type);
            preparedStatement.setString(4, name);
            int lines = preparedStatement.executeUpdate();
            if (lines>0) {
                System.out.println("Data Updated Succesfully!");
            }
            else
            {
                System.out.println("Error Accured!");
            }
        }    
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
