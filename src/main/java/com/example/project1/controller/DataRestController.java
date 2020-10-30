package com.example.project1.controller;

import com.example.project1.data.MatchedRecord;
import com.example.project1.data.TradeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataRestController {

    @Autowired
    private FetchService service;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello world!";
    }

    @GetMapping("/stock/{stock}")
    public List<TradeRecord> listByStock(@PathVariable String stock){
        return service.listByStock(stock);
    }

    @GetMapping("/party/{party}")
    public List<TradeRecord> listByParty(@PathVariable String party){
        return service.listByParty(party);
    }

    @GetMapping("/price/{price}")
    public List<TradeRecord> listByPrice(@PathVariable Float price){
        return service.listByPrice(price);
    }

    @GetMapping("/action/{action}")
    public List<TradeRecord> listByAction(@PathVariable String action) {
        return service.listByAction(action);
    }

    @GetMapping("/match/stock/{stock}")
    public List<MatchedRecord> listMatchByStock(@PathVariable String stock) {
        return service.listMatchByStock(stock);
    }

    @GetMapping("/match/buyer/{name}")
    public List<MatchedRecord> listMatchByBuyer(@PathVariable String name) {
        return service.listMatchByBuyer(name);
    }

    @GetMapping("/match/seller/{name}")
    public List<MatchedRecord> listMatchBySeller(@PathVariable String name) {
        return service.listMatchBySeller(name);
    }

    @GetMapping("/match/price/{price}")
    public List<MatchedRecord> listMatchByPrice(@PathVariable Float price) {
        return service.listMatchByPrice(price);
    }
}
