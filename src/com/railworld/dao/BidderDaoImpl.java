package com.railworld.dao;

import com.railworld.bean.Bidder;
import com.railworld.connection.DB;
import com.railworld.exception.BidderException;
import com.railworld.exception.TenderException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BidderDaoImpl implements BidderDao{
    int master_id;

    private Connection con;

    public BidderDaoImpl() {
        this.con = DB.getConnection();
    }

    @Override
    public String placeBidAgainstTender(int id,int venId, int tenId, int price) throws SQLException, TenderException {

        String result = "Bidding failed!";

        this.master_id = venId;

        PreparedStatement ps1 = this.con.prepareStatement("select * from Tender where id=?");

        ps1.setInt(1, tenId);

        ResultSet rs = ps1.executeQuery();

        if (rs.next()) {

            PreparedStatement ps2 = this.con.prepareStatement("insert into Bidder(id,venId, tenId, price) values(?,?,?,?)");

            ps2.setInt(1,id);
            ps2.setInt(2, master_id);
            ps2.setInt(3, tenId);
            ps2.setInt(4, price);

            int x = ps2.executeUpdate();

            if (x > 0) {
                result = "Bidding successfully...";
            }

        } else {
            throw new TenderException("Tender didn't found with this " + tenId);
        }

        return result;
    }
    @Override
    public Bidder viewStatusOfBid(int id) throws BidderException, SQLException {
        Bidder bidder = null;

        PreparedStatement ps = this.con.prepareStatement("select * from Bidder where id=?");

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int i = rs.getInt("id");
            int vi = rs.getInt("venId");
            int ti = rs.getInt("tenId");
            int p = rs.getInt("price");
            String s = rs.getString("status");

            bidder = new Bidder(i, vi, ti, p, s);
        } else {
            throw new BidderException("Invalid Bidder ID !");
        }

        return bidder;
    }

    @Override
    public List<Bidder> viewOwnBidHistory() throws BidderException, SQLException {
        List<Bidder> bidders = new ArrayList<>();

        PreparedStatement ps = this.con.prepareStatement("select * from Bidder where venId=?");

        ps.setInt(1, master_id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int i = rs.getInt("id");
            int vi = rs.getInt("venId");
            int ti = rs.getInt("tenId");
            int p = rs.getInt("price");
            String s = rs.getString("status");

            bidders.add(new Bidder(i, vi, ti, p, s));
        }

        if (bidders.size() == 0) {
            throw new BidderException("No bids found!");
        }

        return bidders;
    }
    @Override
    public List<Bidder> viewAllBidsOfTender(int tid) throws BidderException, SQLException {
        List<Bidder> bidders = new ArrayList<>();

        PreparedStatement ps = this.con.prepareStatement("select * from Bidder where tenId=?");

        ps.setInt(1, tid);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int i = rs.getInt("id");
            int vi = rs.getInt("venId");
            int ti = rs.getInt("tenId");
            int p = rs.getInt("price");
            String s = rs.getString("status");

            bidders.add(new Bidder(i, vi, ti, p, s));
        }

        if (bidders.size() == 0) {
            throw new BidderException("No bidders found!");
        }

        return bidders;
    }
}
