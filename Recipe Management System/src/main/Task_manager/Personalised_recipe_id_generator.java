package Task_manager;
import java.util.*;
import java.sql.*;
public class Personalised_recipe_id_generator {
    /* Class to generate the personalised recipes idd for premium accounts.*/
    private static String url = "jdbc:mysql://127.0.0.1:3306/Recipe_manager_system";
    private static String username = "root";
    private static String password = "mysql@2004"; 
    public static String Personalised_recipe_id_gen(String acc_id) throws Exception
    {
        String personalised_id = "PSR";
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
            boolean flag1  = false;
            while (flag1==false) {
                int num;
                Random rand = new Random();
                num = rand.nextInt(10000000,100000000);
                String number = Integer.toString(num);
                personalised_id=personalised_id+number;
                Statement statement = connection.createStatement();
                String query = "select personalised_recipes_id from personalised_recipes_ids";
                ResultSet resultSet = statement.executeQuery(query);
                boolean flag2 = false;
                while (resultSet.next()!=false) {
                    String id = resultSet.getString("personalised_recipes_id");
                    if (id.equals(personalised_id)) {
                        flag2=true;
                    }
                }
                if (flag2==false) {
                    String query1 = "insert into personalised_recipes_ids(personalised_recipes_id,Acc_id) values (?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(query1);
                    preparedStatement.setString(1, personalised_id);
                    preparedStatement.setString(2, acc_id);
                    preparedStatement.executeUpdate();
                    flag1=true;
                }
                else
                {
                    flag1=false;
                }
            }
            return personalised_id;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return personalised_id;
    }
}