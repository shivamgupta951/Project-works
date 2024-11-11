package Task_manager;
import java.sql.*;
import java.util.Date;
public class User_details {
    /*  Class to all information display regarding identification */
    private static String url = "jdbc:mysql://127.0.0.1:3306/Recipe_manager_system";
    private static String name = "root";
    private static String password = "mysql@2004"; 
    public static void user_info(int phone_number) throws Exception
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
            Connection connection = DriverManager.getConnection(url, name, password);
            String query = String.format("select Acc_id from user_information where Phone_number = %d", phone_number);
            String acc_id="";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()!=false) {
                String id = resultSet.getString("Acc_id");
                acc_id=acc_id+id;
            }
            System.out.println("");
            System.out.println("Details of Person :- ");
            System.out.println("");
            if (acc_id.charAt(0)=='E' && acc_id.charAt(1)=='X' && acc_id.charAt(2)=='T' ) {
                String query1 = "select * from user_information U inner join EXT E on U.Phone_number = E.Phone_number where U.Phone_number = (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query1);
                preparedStatement.setInt(1, phone_number);
                ResultSet resultSet2 =  preparedStatement.executeQuery();
                while (resultSet2.next()!=false) {
                    String email = resultSet2.getString("Email");
                    Date date = resultSet2.getDate("Dob");
                    String username = resultSet2.getString("Username");
                    String name = resultSet2.getString("Name");
                    int phone = resultSet2.getInt("Phone_number");
                    String rms_password = resultSet2.getString("RMS_password");
                    String profession = resultSet2.getString("Profession");
                    String state = resultSet2.getString("State");
                    String premium_status = resultSet2.getString("Premium_status");
                    String acc_id1 = resultSet2.getString("Acc_id");
                    String location = resultSet2.getString("Location");
                    Date date1 = resultSet2.getDate("Date_registered");
                    String status = resultSet2.getString("status");
                    System.out.println(email);
                    System.out.println(username);
                    System.out.println(date);
                    System.out.println(name);
                    System.out.println(phone);
                    System.out.println(rms_password);
                    System.out.println(profession);
                    System.out.println(state);
                    System.out.println(premium_status);
                    System.out.println(acc_id1);
                    System.out.println(location);
                    System.out.println(date1);
                    System.out.println(status);

 
                }
            }
            else if (acc_id.charAt(0)=='Y' && acc_id.charAt(1)=='I' && acc_id.charAt(2)=='N' ) {
                String query1 = "select * from user_information U inner join YIN Y on U.Phone_number = Y.Phone_number where U.Phone_number = (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query1);
                preparedStatement.setInt(1, phone_number);
                ResultSet resultSet2 =  preparedStatement.executeQuery();
                while (resultSet2.next()!=false) {
                    String email = resultSet2.getString("Email");
                    Date date = resultSet2.getDate("Dob");
                    String username = resultSet2.getString("Username");
                    String name = resultSet2.getString("Name");
                    int phone = resultSet2.getInt("Phone_number");
                    String rms_password = resultSet2.getString("RMS_password");
                    String profession = resultSet2.getString("Profession");
                    String state = resultSet2.getString("State");
                    String premium_status = resultSet2.getString("Premium_status");
                    String acc_id1 = resultSet2.getString("Acc_id");
                    String location = resultSet2.getString("Location");
                    Date date1 = resultSet2.getDate("Date_registered");
                    String status = resultSet2.getString("status");
                    System.out.println(email);
                    System.out.println(username);
                    System.out.println(date);
                    System.out.println(name);
                    System.out.println(phone);
                    System.out.println(rms_password);
                    System.out.println(profession);
                    System.out.println(state);
                    System.out.println(premium_status);
                    System.out.println(acc_id1);
                    System.out.println(location);
                    System.out.println(date1);
                    System.out.println(status);

 
                }
            }
            else if (acc_id.charAt(0)=='S' && acc_id.charAt(1)=='B' && acc_id.charAt(2)=='T' ) {
                String query1 = "select * from user_information U inner join SBT S on U.Phone_number = S.Phone_number where U.Phone_number = (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query1);
                preparedStatement.setInt(1, phone_number);
                ResultSet resultSet2 =  preparedStatement.executeQuery();
                while (resultSet2.next()!=false) {
                    String email = resultSet2.getString("Email");
                    Date date = resultSet2.getDate("Dob");
                    String username = resultSet2.getString("Username");
                    String name = resultSet2.getString("Name");
                    int phone = resultSet2.getInt("Phone_number");
                    String rms_password = resultSet2.getString("RMS_password");
                    String profession = resultSet2.getString("Profession");
                    String state = resultSet2.getString("State");
                    String premium_status = resultSet2.getString("Premium_status");
                    String acc_id1 = resultSet2.getString("Acc_id");
                    String location = resultSet2.getString("Location");
                    Date date1 = resultSet2.getDate("Date_registered");
                    String status = resultSet2.getString("status");
                    System.out.println(email);
                    System.out.println(username);
                    System.out.println(date);
                    System.out.println(name);
                    System.out.println(phone);
                    System.out.println(rms_password);
                    System.out.println(profession);
                    System.out.println(state);
                    System.out.println(premium_status);
                    System.out.println(acc_id1);
                    System.out.println(location);
                    System.out.println(date1);
                    System.out.println(status);

 
                }
            }
            else if (acc_id.charAt(0)=='T' && acc_id.charAt(1)=='R' && acc_id.charAt(2)=='S' ) {
                String query1 = "select * from user_information U inner join TRS T on U.Phone_number = T.Phone_number where U.Phone_number = (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query1);
                preparedStatement.setInt(1, phone_number);
                ResultSet resultSet2 =  preparedStatement.executeQuery();
                while (resultSet2.next()!=false) {
                    String email = resultSet2.getString("Email");
                    Date date = resultSet2.getDate("Dob");
                    String username = resultSet2.getString("Username");
                    String name = resultSet2.getString("Name");
                    int phone = resultSet2.getInt("Phone_number");
                    String rms_password = resultSet2.getString("RMS_password");
                    String profession = resultSet2.getString("Profession");
                    String state = resultSet2.getString("State");
                    String premium_status = resultSet2.getString("Premium_status");
                    String acc_id1 = resultSet2.getString("Acc_id");
                    String location = resultSet2.getString("Location");
                    Date date1 = resultSet2.getDate("Date_registered");
                    String status = resultSet2.getString("status");
                    System.out.println(email);
                    System.out.println(username);
                    System.out.println(date);
                    System.out.println(name);
                    System.out.println(phone);
                    System.out.println(rms_password);
                    System.out.println(profession);
                    System.out.println(state);
                    System.out.println(premium_status);
                    System.out.println(acc_id1);
                    System.out.println(location);
                    System.out.println(date1);
                    System.out.println(status);

 
                }
            }
            else if (acc_id.charAt(0)=='P' && acc_id.charAt(1)=='N' && acc_id.charAt(2)=='T' ) {
                String query1 = "select * from user_information U inner join PNT P on U.Phone_number = P.Phone_number where U.Phone_number = (?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query1);
                preparedStatement.setInt(1, phone_number);
                ResultSet resultSet2 =  preparedStatement.executeQuery();
                while (resultSet2.next()!=false) {
                    String email = resultSet2.getString("Email");
                    Date date = resultSet2.getDate("Dob");
                    String username = resultSet2.getString("Username");
                    String name = resultSet2.getString("Name");
                    int phone = resultSet2.getInt("Phone_number");
                    String rms_password = resultSet2.getString("RMS_password");
                    String profession = resultSet2.getString("Profession");
                    String state = resultSet2.getString("State");
                    String premium_status = resultSet2.getString("Premium_status");
                    String acc_id1 = resultSet2.getString("Acc_id");
                    String location = resultSet2.getString("Location");
                    Date date1 = resultSet2.getDate("Date_registered");
                    String status = resultSet2.getString("status");
                    System.out.println(email);
                    System.out.println(username);
                    System.out.println(date);
                    System.out.println(name);
                    System.out.println(phone);
                    System.out.println(rms_password);
                    System.out.println(profession);
                    System.out.println(state);
                    System.out.println(premium_status);
                    System.out.println(acc_id1);
                    System.out.println(location);
                    System.out.println(date1);
                    System.out.println(status);
                }
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
