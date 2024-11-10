package Task_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Password_manager {
    /*Class to update the password with acc_id and phone number in the database table. */
    private static String url = "jdbc:mysql://127.0.0.1:3306/Recipe_manager_system";
    private static String username = "root";
    private static String password = "mysql@2004"; 
    public static void password_storage(String rms_password , String email , String acc_id, String acc_type , int phone_number) 
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
            Connection connection = DriverManager.getConnection( url, username, password);
            String query = "insert into password_storage(Passwords,Acc_id,Email,Acc_type,Phone_number) values (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, rms_password);
            preparedStatement.setString(2, acc_id);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, acc_type);
            preparedStatement.setInt(5, phone_number);
            preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }
}

