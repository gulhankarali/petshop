package jdbctests;

import org.testng.annotations.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class dbUtilDemo {

    @Test
    public void Test1(){

        DBUtils.createConnection();
        String query= "select * from employees where employee_id=101";

        List<Map<String, Object>> queryData = DBUtils.getQueryResultMap(query); // for a couple of rows

        Map<String, Object> rowMap= DBUtils.getRowMap(query); //only one row

        for(Map<String, Object> row: queryData){
            System.out.println(row);
        }

        DBUtils.destroy();
    }
}
