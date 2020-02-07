package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jdbc_utilexample extends TestBase {

  //  String dbUrl = "jdbc:oracle:thin:@3.94.251.137:1521:xe";
  //  String dbUsername = "hr";
 //   String dbPassword = "hr";

    @Test
    public void metadata() throws SQLException {
     //   Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
     //   Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from departments");

        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        System.out.println("Column count:"+rsMetadata.getColumnCount());

        int columnCount = rsMetadata.getColumnCount();
        for (int i = 1; i <=columnCount; i++) {
            //System.out.println(rsMetadata.getColumnName(i));
        }
        List<Map<String,Object>> queryData = new ArrayList<>();
        Map<String,Object> row1 = new HashMap<>();
        row1.put("first_name","Steven");
        row1.put("last_name","King");
        row1.put("salary",24000);
        row1.put("job_id","AD_PRESS");
        System.out.println(row1.toString());
        // get the first
        System.out.println(row1.get("first_name"));
        //--------------get row 2
        Map<String,Object> row2 = new HashMap<>();
        row2.put("first_name","Neena");
        row2.put("last_name","Kochhar");
        row2.put("salary",17000);
        row2.put("job_id","AD_VP");
        //adding rows to my list
        queryData.add(row1);
        queryData.add(row2);
        System.out.println("Neena Salary: "+queryData.get(1).get("salary"));
        System.out.println("Steven JobId: "+queryData.get(0).get("job_id"));

        resultSet.close();
    //    statement.close();
    //    connection.close();
    }

}
