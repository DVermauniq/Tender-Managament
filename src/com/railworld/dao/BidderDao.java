package com.railworld.dao;

import com.railworld.bean.Bidder;
import com.railworld.exception.BidderException;
import com.railworld.exception.TenderException;
import java.sql.SQLException;
import java.util.List;

public interface BidderDao {
    public String placeBidAgainstTender(int id,int venId, int tenId, int price) throws TenderException, SQLException;
    public Bidder viewStatusOfBid(int id) throws BidderException, SQLException;

    public List<Bidder> viewOwnBidHistory() throws BidderException, SQLException;
    public List<Bidder> viewAllBidsOfTender(int tenId) throws BidderException, SQLException;
}
