package com.example.project1.data;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.text.MessageFormat;

public class TradeRecord {
    @Id
    private Timestamp tradeTimestamp;
    private String stockName;
    private Float price;
    private String action;
    private String party;
    private Boolean completed;

    public TradeRecord(Timestamp tradeTimestamp, String stockName, Float price,
                       String action, String party, Boolean completed) {
        this.stockName = stockName;
        this.price = price;
        this.party = party;
        this.tradeTimestamp = tradeTimestamp;
        this.action = action;
        this.completed = completed;
    }

    public void printRecord(){
        System.out.println(MessageFormat.format("Stock name: {0}", this.stockName));
        System.out.println(MessageFormat.format("Price: {0}", this.price));
        System.out.println(MessageFormat.format("Party: {0}", this.party));
        System.out.println(MessageFormat.format("Action: {0}", this.action));
        System.out.println(MessageFormat.format("Timestamp: {0}", this.tradeTimestamp.toString() ));
    }

    public Timestamp getTradeTimestamp() {
        return tradeTimestamp;
    }

    public String getStockName() {
        return stockName;
    }

    public Float getPrice() {
        return price;
    }

    public String getParty() {
        return party;
    }
}
