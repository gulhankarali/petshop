package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;

public class jdbc_examples {
    String dbUrl = "jdbc:oracle:thin:@3.94.251.137:1521:xe";
    String dbUsername="hr";
    String dbPassword="hr";

    @Test
    public void test1() {

        try {
            Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select region_name from regions");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("region_name"));
            }
            resultSet = statement.executeQuery("select country_name from countries");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("country_name"));
            }

            resultSet.close();
            statement.close();
            connection.close();

            } catch (Exception e){
                System.out.println(e);
            }

    }

    @Test
    public void CountAndNavigate() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");

        resultSet.last();
        int rowCount= resultSet.getRow();
        System.out.println(rowCount);

        resultSet.beforeFirst();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("first_name"));
        }



        resultSet.close();
        statement.close();
        connection.close();
    }
}
