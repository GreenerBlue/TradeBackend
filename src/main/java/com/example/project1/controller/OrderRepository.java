package com.example.project1.controller;

import com.example.project1.data.TradeRecord;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<TradeRecord,String>{
    @Query("select * from ordertb where party=:pname")
    List<TradeRecord> listByParty(@Param("pname") String pName);

    @Query("select * from ordertb where stockname=:stname")
    List<TradeRecord> listByStock(@Param("stname") String stname);

    @Query("select * from ordertb where price=:price")
    List<TradeRecord> listByPrice(@Param("price") Float price);

    @Query("select * from ordertb where orderaction=:action")
    List<TradeRecord> listByAction(@Param("action") String action);
}