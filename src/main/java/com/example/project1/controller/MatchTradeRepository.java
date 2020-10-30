package com.example.project1.controller;

import com.example.project1.data.MatchedRecord;
import com.example.project1.data.TradeRecord;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchTradeRepository extends CrudRepository<MatchedRecord,String> {
    @Query("select * from matchedtradetb where stockname=:stname")
    List<MatchedRecord> listMatchByStock(@Param("stname") String stname);

    @Query("select * from matchedtradetb where buyer=:bname")
    List<MatchedRecord> listMatchByBuyer(@Param("bname") String bname);

    @Query("select * from matchedtradetb where seller=:sname")
    List<MatchedRecord> listMatchBySeller(@Param("sname") String sname);

    @Query("select * from matchedtradetb where price=:price")
    List<MatchedRecord> listMatchByPrice(@Param("price") Float price);

}
