package Account_registration;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;
public class Account_generation {
    /*Automatic User Acc_id generator*/
    private static String url = "jdbc:mysql://127.0.0.1:3306/Recipe_manager_system";
    private static String username = "root";
    private static String password = "mysql@2004";    
    public static String create_accountidd(int phoneno) throws Exception{
        String value="";
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
            int ph_number=phoneno;
            LocalDate date = LocalDate.now();
            String formattedString = date.toString();
            Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(formattedString);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); 
            int count=0;
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            boolean created = false;
            while (created==false) {
                Random rand = new Random();
                int number = rand.nextInt(10000000,100000000);
                String var="";
                int num = rand.nextInt(1,6);
                if (num==1) {
                    var = var+"EXT";
                }
                else if (num==2) {
                    var=var+"YIN";
                }
                else if (num==3) {
                    var=var+"SBT";
                }
                else if (num==4) {
                    var=var+"TRS";
                }
                else if (num==5) {
                    var=var+"PNT";
                }
                String strnum = Integer.toString(number);
                String generated_Acc_id=var+strnum;
                String user=generated_Acc_id;
                boolean ques1 = false;
                /* checking dublicate  user Acc_id in tables */
                if (user.charAt(0)=='E' && user.charAt(1)=='X' && user.charAt(2)=='T' ) {
                    String query1 = "Select * from EXT";
                    ResultSet resultSet = statement.executeQuery(query1);
                    int temp=0;
                    while (resultSet.next()!=false) {
                        String values = resultSet.getString("Acc_id");
                        temp=temp+1;
                        boolean condition = values.equals(user);
                        if (condition==true) {
                            ques1=true;
                            break;
                        }
                    }
                    count=temp+1;
                }
                else if (user.charAt(0)=='Y' && user.charAt(1)=='I' && user.charAt(2)=='N' ) {
                    String query1 = "Select * from YIN";
                    ResultSet resultSet = statement.executeQuery(query1);
                    int temp=0;
                    while (resultSet.next()!=false) {
                        String values = resultSet.getString("Acc_id");
                        temp=temp+1;
                        boolean condition = values.equals(user);
                        if (condition==true) {
                            ques1=true;
                            break;
                        }
                    }
                    count=temp+1;
                }
                else if (user.charAt(0)=='S' && user.charAt(1)=='B' && user.charAt(2)=='T' ) {
                    String query1 = "Select * from SBT";
                    ResultSet resultSet = statement.executeQuery(query1);
                    int temp=0;
                    while (resultSet.next()!=false) {
                        String values = resultSet.getString("Acc_id");
                        temp=temp+1;
                        boolean condition = values.equals(user);
                        if (condition==true) {
                            ques1=true;
                            break;
                        }
                    }
                    count=temp+1;
                }
                else if (user.charAt(0)=='T' && user.charAt(1)=='R' && user.charAt(2)=='S' ) {
                    String query1 = "Select * from TRS";
                    ResultSet resultSet = statement.executeQuery(query1);
                    int temp=0;
                    while (resultSet.next()!=false) {
                        String values = resultSet.getString("Acc_id");
                        temp=temp+1;
                        boolean condition = values.equals(user);
                        if (condition==true) {
                            ques1=true;
                            break;
                        }
                    }
                    count=temp+1;
                }
                else if (user.charAt(0)=='P' && user.charAt(1)=='N' && user.charAt(2)=='T' ) {
                    String query1 = "Select * from PNT";
                    ResultSet resultSet = statement.executeQuery(query1);
                    int temp=0;
                    while (resultSet.next()!=false) {
                        String values = resultSet.getString("Acc_id");
                        temp=temp+1;
                        boolean condition = values.equals(user);
                        if (condition==true) {
                            ques1=true;
                            break;
                        }
                    }
                    count=temp+1;
                }
                if (ques1==false) {
                    System.out.println();
                    value=value+user;
                    created=true;
                    if (user.charAt(0)=='E' && user.charAt(1)=='X' && user.charAt(2)=='T')
                    {
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into EXT(Acc_id,location,counts,Date_registered,status,Phone_number) values (?,?,?,?,?,?)");
                        preparedStatement.setString(1, user);
                        preparedStatement.setString(2, "INDIA");
                        preparedStatement.setInt(3, count);
                        preparedStatement.setDate(4, sqlDate);
                        preparedStatement.setString(5, "Normal Version");
                        preparedStatement.setInt(6,ph_number);
                        preparedStatement.executeUpdate();
                    }
                    else if (user.charAt(0)=='Y' && user.charAt(1)=='I' && user.charAt(2)=='N')
                    {
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into YIN(Acc_id,location,counts,Date_registered,status,Phone_number) values (?,?,?,?,?,?)");
                        preparedStatement.setString(1, user);
                        preparedStatement.setString(2, "INDIA");
                        preparedStatement.setInt(3, count);
                        preparedStatement.setDate(4, sqlDate);
                        preparedStatement.setString(5, "Normal Version");
                        preparedStatement.setInt(6,ph_number);
                        preparedStatement.executeUpdate();
                    }
                    else if (user.charAt(0)=='S' && user.charAt(1)=='B' && user.charAt(2)=='T')
                    {
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into SBT(Acc_id,location,counts,Date_registered,status,Phone_number) values (?,?,?,?,?,?)");
                        preparedStatement.setString(1, user);
                        preparedStatement.setString(2, "INDIA");
                        preparedStatement.setInt(3, count);
                        preparedStatement.setDate(4, sqlDate);
                        preparedStatement.setString(5, "Normal Version");
                        preparedStatement.setInt(6,ph_number);
                        preparedStatement.executeUpdate();
                    }
                    else if (user.charAt(0)=='T' && user.charAt(1)=='R' && user.charAt(2)=='S')
                    {
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into TRS(Acc_id,location,counts,Date_registered,status,Phone_number) values (?,?,?,?,?,?)");
                        preparedStatement.setString(1, user);
                        preparedStatement.setString(2, "INDIA");
                        preparedStatement.setInt(3, count);
                        preparedStatement.setDate(4, sqlDate);
                        preparedStatement.setString(5, "Normal Version");
                        preparedStatement.setInt(6,ph_number);
                        preparedStatement.executeUpdate();
                    }
                    else if (user.charAt(0)=='P' && user.charAt(1)=='N' && user.charAt(2)=='T')
                    {
                        PreparedStatement preparedStatement = connection.prepareStatement("insert into PNT(Acc_id,location,counts,Date_registered,status,Phone_number) values (?,?,?,?,?,?)");
                        preparedStatement.setString(1, user);
                        preparedStatement.setString(2, "INDIA");
                        preparedStatement.setInt(3, count);
                        preparedStatement.setDate(4, sqlDate);
                        preparedStatement.setString(5, "Normal Version");
                        preparedStatement.setInt(6,ph_number);
                        preparedStatement.executeUpdate();
                    }
                }
                else
                {
                    created=false;
                }
            }
            connection.close();
        }    
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return value;
    }
}
