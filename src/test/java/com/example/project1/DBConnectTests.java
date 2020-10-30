package com.example.project1;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectTests {
    @Test
    void connectTest(){
        DBConnect db = new DBConnect();
        Connection c = db.connectToDb();
        String sqlQuery = """
                    CREATE TABLE testtable (
                        testcolumn int
                    );
                """;
        try{
            Statement s = c.createStatement();
            s.execute(sqlQuery);
            s.executeUpdate("INSERT INTO testtable VALUES(1);");
            ResultSet rs = s.executeQuery("SELECT * FROM testtable;");
            while(rs.next())
                assert rs.getInt("testcolumn")==1;
            rs.close();
            s.execute("DROP TABLE testtable;");
        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
