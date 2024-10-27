import java.sql.*;
public class App {
    public static String url ="jdbc:mysql://localhost:3306/collage1";
    public static String username ="root";
    public static String password ="Sg@9090";
    public static void main(String[] args) throws Exception {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage1", "root", "Sg@9090");
            Statement statement = connection.createStatement();
            String query ="select * from Students";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()!=false) {
                int id = resultSet.getInt("Id");
                int age = resultSet.getInt("Age");
                int section = resultSet.getInt("Section");
                String course = resultSet.getString("Course");
                String sname = resultSet.getString("Sname");
                System.out.println("ID: "+id);
                System.out.println("NAME: "+sname);
                System.out.println("AGE: "+age);
                System.out.println("SECTION: "+section);
                System.out.println("COURSE: "+course);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
