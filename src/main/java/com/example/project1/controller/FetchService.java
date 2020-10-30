package com.example.project1.controller;

import com.example.project1.data.MatchedRecord;
import com.example.project1.data.TradeRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private MatchTradeRepository matchRepository;

    public List<TradeRecord> listByStock(String stName) {
        return repository.listByStock(stName);
    }

    public List<TradeRecord> listByParty(String party) {
        return repository.listByParty(party);
    }

    public List<TradeRecord> listByPrice(Float price) {
        return repository.listByPrice(price);
    }

    public List<TradeRecord> listByAction(String action) {
        return repository.listByAction(action);
    }

    public List<MatchedRecord> listMatchByStock(String stock) {
        return matchRepository.listMatchByStock(stock);
    }

    public List<MatchedRecord> listMatchByBuyer(String name) {
        return matchRepository.listMatchByBuyer(name);
    }

    public List<MatchedRecord> listMatchBySeller(String name) {
        return matchRepository.listMatchBySeller(name);
    }

    public List<MatchedRecord> listMatchByPrice(Float price) {
        return matchRepository.listMatchByPrice(price);
    }
}
