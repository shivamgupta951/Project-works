package Premium_Recipies;
import java.sql.*;
public class Premium_accounts {
    private static String url = "jdbc:mysql://127.0.0.1:3306/Recipe_manager_system";
    private static String username = "root";
    private static String password = "mysql@2004";    
    public static void update_to_premium(String Acc_id , int Phone_number)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url, username, password);
            String query = "UPDATE user_information SET Premium_status = 'YES' Where Phone_number = (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Phone_number);
            boolean flag1=false;
            boolean flag2=false;
            int lines = preparedStatement.executeUpdate();
            if (lines>0) {
                flag1=true;
            }
            if (Acc_id.charAt(0)=='E' && Acc_id.charAt(1)=='X' &&Acc_id.charAt(0)=='T' ) {
                String query1 = "UPDATE EXT SET status = 'Premium Version' Where Acc_id = (?)";
                PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
                preparedStatement1.setString(1, Acc_id);
                int lines1 = preparedStatement1.executeUpdate();
                if (lines1>0) {
                    flag2=true;
                }
            }
            else if (Acc_id.charAt(0)=='Y' && Acc_id.charAt(1)=='I' &&Acc_id.charAt(2)=='N' ) {
                String query1 = "UPDATE YIN SET status = 'Premium Version' Where Acc_id = (?)";
                PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
                preparedStatement1.setString(1, Acc_id);
                int lines1 = preparedStatement1.executeUpdate();
                if (lines1>0) {
                    flag2=true;
                }
            }
            else if (Acc_id.charAt(0)=='S' && Acc_id.charAt(1)=='B' &&Acc_id.charAt(2)=='T' ) {
                String query1 = "UPDATE SBT SET status = 'Premium Version' Where Acc_id = (?)";
                PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
                preparedStatement1.setString(1, Acc_id);
                int lines1 = preparedStatement1.executeUpdate();
                if (lines1>0) {
                    flag2=true;
                }
            }
            else if (Acc_id.charAt(0)=='T' && Acc_id.charAt(1)=='R' &&Acc_id.charAt(2)=='S' ) {
                String query1 = "UPDATE TRS SET status = 'Premium Version' Where Acc_id = (?)";
                PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
                preparedStatement1.setString(1, Acc_id);
                int lines1 = preparedStatement1.executeUpdate();
                if (lines1>0) {
                    flag2=true;
                }
            }
            else if (Acc_id.charAt(0)=='P' && Acc_id.charAt(1)=='N' &&Acc_id.charAt(2)=='T' ) {
                String query1 = "UPDATE PNT SET status = 'Premium Version' Where Acc_id = (?)";
                PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
                preparedStatement1.setString(1, Acc_id);
                int lines1 = preparedStatement1.executeUpdate();
                if (lines1>0) {
                    flag2=true;
                }
            }
            if (flag1==true && flag2==true) {
                System.out.println("Account with Account id - "+Acc_id+" is succesfully upgraded to premium version ~!");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
