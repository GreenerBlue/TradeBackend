package com.example.project1.data;

import java.sql.Timestamp;

public class MatchedRecord {
    private final Timestamp ordertimestamp;
    private final String stockname;
    private final Float price;
    private final String seller;
    private final String buyer;

    public MatchedRecord(Timestamp ordertimestamp, String stockname, Float price, String seller, String buyer) {
        this.ordertimestamp = ordertimestamp;
        this.stockname = stockname;
        this.price = price;
        this.seller = seller;
        this.buyer = buyer;
    }

    public Timestamp getOrdertimestamp() {
        return ordertimestamp;
    }

    public String getStockname() {
        return stockname;
    }

    public Float getPrice() {
        return price;
    }

    public String getSeller() {
        return seller;
    }

    public String getBuyer() {
        return buyer;
    }
}
