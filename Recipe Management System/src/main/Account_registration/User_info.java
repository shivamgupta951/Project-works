package Account_registration;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class User_info {
    /*Class is created to store the user info that are inputed by the user. */
    public static String get_username(String email)
    {
        int len = email.length();
        int point=0;
        for (int i = 0; i <len; i++) {
            char value = email.charAt(i);
            if (value=='@') {
                point=i;
                break;
            }
        }
        String username = email.substring(0, point);
        return username;
    }
    private static String url = "jdbc:mysql://127.0.0.1:3306/Recipe_manager_system";
    private static String username = "root";
    private static String password = "mysql@2004";    
    public static void user_registration(String email,String dob,String name,int phone_number,String rms_password,String profession,String state) throws Exception
    {
        int account_counts=0;
        String premium_status="NO"; 
        String acc_id; 
        String usernames=get_username(email);
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
        java.sql.Date date_of_birth = new java.sql.Date(date.getTime());
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
            Statement statement = connection.createStatement();
            String query3 = String.format("Select Total_Accounts_Count from user_information where Username = %s", "Account-setup"); 
            ResultSet resultSet = statement.executeQuery(query3);
            while (resultSet.next()!=false) {
                account_counts = resultSet.getInt("Total_AccountS_Count");
            }
            account_counts=account_counts+1;
            String query = "insert into user_information(Email,Dob,Username,Name,Phone_number,RMS_password,Profession,State,Premium_status,Total_Accounts_Count) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            boolean flag=false;
            preparedStatement.setString(1, email);
            preparedStatement.setDate(2, date_of_birth);
            preparedStatement.setString(3, usernames);
            preparedStatement.setString(4, name);
            preparedStatement.setInt(5, phone_number);
            preparedStatement.setString(6, rms_password);
            preparedStatement.setString(7, profession);
            preparedStatement.setString(8, state);
            preparedStatement.setString(9, premium_status);
            preparedStatement.setInt(10, account_counts);
            int lines=preparedStatement.executeUpdate();
            if (lines>0) {
                flag=true;
              }
            acc_id=Account_generation.create_accountidd(phone_number);
            String query2 = "insert into user_information(Acc_id) values (?)";
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            boolean flag2=false;
            preparedStatement2.setString(1, acc_id);
            int lines2=preparedStatement2.executeUpdate();
            if (lines2>0) {
                flag2=true;
            }
            else
            {
                flag2=flag;
            }
            if (flag==true && flag2==true) {
                System.out.println("");
                System.out.println("");
                System.out.println("Account Succesfully registered with username: "+usernames+" and RMS Account id: "+acc_id+" ~!");
                System.out.println("Total Account counts => "+account_counts);
            }
            connection.close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }
} 
