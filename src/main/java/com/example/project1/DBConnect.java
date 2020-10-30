package com.example.project1;

import java.sql.*;
import com.example.project1.data.TradeRecord;

import java.text.MessageFormat;
import java.util.ArrayList;

public class DBConnect {
    public Connection con;
    public DBConnect() {
        final String url = "jdbc:postgresql://localhost:5433/Project1";
        final String user = "postgres";
        final String pass = "welcome123";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("Connectide successfully");
        } catch (Exception throwable) {
            throwable.printStackTrace();
        }
        this.con=con;
    }

    public Connection connectToDb(){
        return con;
    }

    public ArrayList<TradeRecord> getRecordsFromDb(){
        return getRecordsFromDb("");
    }

    public ArrayList<TradeRecord> getRecordsFromDb(String filterAction){
        Connection c = connectToDb();
        ArrayList<TradeRecord> recordList = new ArrayList<>();
        String query;
        if(filterAction.equals(""))
            query = "SELECT * FROM ordertb WHERE processed=false;";
        else
            query = "SELECT * FROM ordertb WHERE processed=false AND orderaction='"
                    + filterAction + "';";
        try (Statement stmt = c.createStatement()) {
            ResultSet records = stmt.executeQuery(query);
            while(records.next()){
                TradeRecord current = new TradeRecord(records.getTimestamp(1),
                        records.getString(2), records.getFloat(3),
                        records.getString(4),  records.getString(5),
                        records.getBoolean(6));
                recordList.add(current);
            }
            records.close();
        } catch (SQLException throwers) {
            throwers.printStackTrace();
        }
        return recordList;
    }
    public static void fillDbWithValues(){
        DBConnect db = new DBConnect();
        Connection c = db.connectToDb();
        String[] stockNames = new String[] {"IBM", "INFY", "GOOG", "AMZN", "MSFT",
                    "PYPL", "FB", "AAPL", "NTDOY", "NFLX" };
        String[] parties = new String[] {"Party1", "Party2", "Party3", "Party4", "Party5"};
        String[] actions = new String[] {"Buy", "Sell"};
        try(Statement s = c.createStatement()){
            for(int i=0; i<100; ++i){
                int stockSeed = (int) (Math.random() * 10);
                int partySeed = (int) (Math.random() * 5);
                String x = MessageFormat.format("INSERT INTO ordertb VALUES( " +
                        "now(), ''{0}'', 100, ''{1}'', ''{2}'', False);",
                        stockNames[stockSeed], actions[i%2], parties[partySeed]);
                s.executeUpdate(x);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args)  {
        DBConnect.fillDbWithValues();

        DBConnect db = new DBConnect();
        /*
        ArrayList<TradeRecord> ll = db.getRecordsFromDb();
        for (TradeRecord rec : ll){
            rec.printRecord();
        }
        try {
            db.con.close();
        } catch (SQLException throwers) {
            throwers.printStackTrace();
        }
        */

    }
}
/* ordertimestamp, stname, price, tradeaction, party, processed */