package jdbctests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.sql.*;

public class TestBase {
    Connection connection;
    Statement statement;

    @BeforeMethod
    public void createConnection() throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@3.94.251.137:1521:xe";
        String dbUsername="hr";
        String dbPassword="hr";
        connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }

    @AfterMethod
    public void tearDownConnection() throws SQLException {
        statement.close();
        connection.close();
    }
}
