package com.example.project1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.project1.data.TradeRecord;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;


@SpringBootApplication
public class Project1Application {

	public static void main(String[] args) {
		try {
			matchTrades();
		}
		catch (SQLException e) {e.printStackTrace();}
		//SpringApplication.run(Project1Application.class, args);
	}

	public static void matchTrades() throws SQLException {
		DBConnect db = new DBConnect();
		ArrayList<TradeRecord> buyList = db.getRecordsFromDb("Buy");
		ArrayList<TradeRecord> sellList = db.getRecordsFromDb("Sell");
		Connection c = db.connectToDb();
		Statement s = c.createStatement();
		String insertQuery, updateQuery;
		for (Iterator<TradeRecord> it = sellList.iterator(); it.hasNext(); ) {
			TradeRecord record1 = it.next();
			for (Iterator<TradeRecord> it2 = buyList.iterator(); it2.hasNext(); ) {
				TradeRecord record2 = it2.next();
				if (Objects.equals(record1.getStockName(), record2.getStockName()) &&
						Objects.equals(record1.getPrice(), record2.getPrice())) {
					insertQuery = MessageFormat.format("INSERT INTO matchedtradetb VALUES(" +
									"now(), ''{0}'', {1}, ''{2}'', ''{3}'');", record1.getStockName(), record1.getPrice(),
							record1.getParty(), record2.getParty());

					s.executeUpdate(insertQuery);
					updateQuery = MessageFormat.format("UPDATE ordertb SET processed=true where ordertimestamp=''{0}''",
							record1.getTradeTimestamp().toString());
					s.executeUpdate(updateQuery);
					updateQuery = MessageFormat.format("UPDATE ordertb SET processed=true where ordertimestamp=''{0}''",
							record2.getTradeTimestamp().toString());
					s.executeUpdate(updateQuery);
					it2.remove();
					it.remove();
					break;
				}
			}
		}
		db.con.close();
	}

}
