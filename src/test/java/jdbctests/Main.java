package jdbctests;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        String dbUrl = "jdbc:oracle:thin:@3.94.251.137:1521:xe";
        String dbUsername="hr";
        String dbPassword="hr";

        Connection connection= DriverManager.getConnection(dbUrl,dbUsername, dbPassword);
        Statement statement= connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select * from regions");
        resultSet.next();
        System.out.println(resultSet.getString("REGION_NAME"));
        resultSet.close();
        statement.close();
        connection.close();
    }
}
