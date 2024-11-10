package Task_manager;
import java.util.*;
import java.sql.*;
public class Recipies_id_generator {
    /* Class to generate the recipes idd for Normal version as well as premium version. */
    private static String url = "jdbc:mysql://127.0.0.1:3306/Recipe_manager_system";
    private static String username = "root";
    private static String password = "mysql@2004";   
    public static int number_gen()
    {
        int num;
        Random rand = new Random();
        num = rand.nextInt(1000000,10000000);
        return num;
    }
    public static String generate_id(String type)
    {
        String id ="";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            if (type=="Normal Version") {
                boolean flag = false;
                while (flag==false) {
                    int number = number_gen();
                    id=id+"NVR";
                    String num = Integer.toString(number);
                    id=id+num;
                    String query = "select Recipe_id from Normal_recipes_id";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    boolean flag2=false;
                    while (resultSet.next()!=false) {
                        String value =  resultSet.getString("Recipe_id");
                        if (value.equals(id)==true) {
                            flag2=true;
                            break;
                        }
                    }
                    if (flag2==true) {
                        flag=false;
                    }
                    else
                    {
                        flag=true;
                    }
                }
                String query1 = "Insert into Normal_recipes_id(Recipe_id,Rating) values (?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query1);
                preparedStatement.setString(1, id);
                preparedStatement.setInt(2, 5);
                preparedStatement.executeUpdate();
            }
            else if (type=="Premium Version") {
                boolean flag = false;
                while (flag==false) {
                    int number = number_gen();
                    id=id+"PVR";
                    String num = Integer.toString(number);
                    id=id+num;
                    String query = "select Recipe_id from Premium_recipes_id";
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);
                    boolean flag2=false;
                    while (resultSet.next()!=false) {
                        String value =  resultSet.getString("Recipe_id");
                        if (value.equals(id)==true) {
                            flag2=true;
                            break;
                        }
                    }
                    if (flag2==true) {
                        flag=false;
                    }
                    else
                    {
                        flag=true;
                    }
                }
                String query1 = "Insert into Premium_recipes_id(Recipe_id,Rating) values (?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query1);
                preparedStatement.setString(1, id);
                preparedStatement.setInt(2, 5);
                preparedStatement.executeUpdate();
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return id;
    }
}
