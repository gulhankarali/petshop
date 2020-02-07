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
        resultSet.beforeFirst();
        resultSet.absolute(4);
        System.out.println(resultSet.getObject("last_name"));

        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void metadata() throws SQLException {

        Connection connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from employees");

        DatabaseMetaData dbMetaData= connection.getMetaData();
        System.out.println("user "+ dbMetaData.getUserName());
        System.out.println("Database product name "+dbMetaData.getDatabaseProductName());
        System.out.println("Database product version "+ dbMetaData.getDatabaseProductVersion());
        System.out.println("Driver "+dbMetaData.getDriverName());
        System.out.println("Driver version "+dbMetaData.getDriverVersion());

        ResultSetMetaData rsMetaData= resultSet.getMetaData();
        System.out.println("Count coloums "+rsMetaData.getColumnCount());
        System.out.println("Column names "+rsMetaData.getColumnName(2));
        System.out.println("Column names "+rsMetaData.getColumnName(8));


        for (int i=1; i<rsMetaData.getColumnCount();i++) {
            System.out.println("Column names " + rsMetaData.getColumnName(i));
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
