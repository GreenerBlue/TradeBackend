package com.example.project1.data;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.text.MessageFormat;

public class TradeRecord {
    @Id
    private final Timestamp ordertimestamp;
    private final String stockname;
    private final Float price;
    private final String action;
    private final String party;

    public TradeRecord(Timestamp ordertimestamp, String stockname, Float price,
                       String action, String party) {
        this.stockname = stockname;
        this.price = price;
        this.party = party;
        this.ordertimestamp = ordertimestamp;
        this.action = action;
    }

    public void printRecord(){
        System.out.println(MessageFormat.format("Stock name: {0}", this.stockname));
        System.out.println(MessageFormat.format("Price: {0}", this.price));
        System.out.println(MessageFormat.format("Party: {0}", this.party));
        System.out.println(MessageFormat.format("Action: {0}", this.action));
        System.out.println(MessageFormat.format("Timestamp: {0}", this.ordertimestamp.toString() ));
    }

    public Timestamp getOrdertimestamp() {
        return ordertimestamp;
    }

    public String getStockName() {
        return stockname;
    }

    public Float getPrice() {
        return price;
    }

    public String getParty() {
        return party;
    }

    public String getAction() {
        return action;
    }
}
