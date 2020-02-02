package jdbctests;
import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SQLException {

        String dbUrl = "jdbc:oracle:thin:@3.94.251.137:1521:xe";
        String dbUsername="hr";
        String dbPassword="hr";

        Connection connection= DriverManager.getConnection(dbUrl,dbUsername, dbPassword);
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select * from employees");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getDouble("salary"));
            System.out.println(resultSet.getObject("department_id"));
        }


        resultSet.close();
        statement.close();
        connection.close();
    }
}
