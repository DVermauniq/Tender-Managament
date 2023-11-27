package com.railworld.dao;


import com.railworld.bean.Tender;
import com.railworld.exception.BidderException;
import com.railworld.exception.TenderException;
import java.sql.SQLException;
import java.util.List;

public interface TenderDao {

    public List<Tender> viewAllTender() throws TenderException, SQLException;
    public String createTender(int id, String name, String type, int price, String location) throws TenderException, SQLException;
    public String assignTenderToVendor(int vid, int tid) throws BidderException, SQLException;

}
