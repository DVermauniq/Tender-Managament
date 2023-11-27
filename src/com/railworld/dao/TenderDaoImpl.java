package com.railworld.dao;

import com.railworld.bean.Tender;
import com.railworld.connection.DB;
import com.railworld.exception.BidderException;
import com.railworld.exception.TenderException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TenderDaoImpl implements TenderDao {
    int master_id;

    private Connection con;

    public TenderDaoImpl() {
        this.con = DB.getConnection();
    }
    @Override
    public List<Tender> viewAllTender() throws SQLException, TenderException {

        List<Tender> tenders = new ArrayList<>();

        PreparedStatement ps = this.con.prepareStatement("select * from tender");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int i = rs.getInt("tId");
            String n = rs.getString("tName");
            String t = rs.getString("tType");
            int p = rs.getInt("tPrice");
            String l = rs.getString("tLocation");

            tenders.add(new Tender(i, n, t, p, l));
        }

        if (tenders.size() == 0) {
            throw new TenderException("No vendor found!");
        }

        return tenders;
    }

    @Override
    public String createTender(int tId, String tName, String tType, int tPrice, String tLocation)
            throws  SQLException {

        String result = "Tender creation failed";

        PreparedStatement ps = this.con.prepareStatement("insert into tender values(?,?,?,?,?)");

        ps.setInt(1, tId);
        ps.setString(2, tName);
        ps.setString(3, tType);
        ps.setInt(4, tPrice);
        ps.setString(5, tLocation);

        int x = ps.executeUpdate();
        if (x > 0) {
            result = "Tender created successfully.";
        }

        return result;
    }


    @Override
    public String assignTenderToVendor(int vendor_Id, int tender_Id) throws  SQLException {
        String result = "Invalid details provided!";

        PreparedStatement ps = this.con
                .prepareStatement("update bidder set bStatus = 'selected' where vendor_id=? AND tender_id=?");

        ps.setInt(1, vendor_Id);
        ps.setInt(2, tender_Id);

        int x = ps.executeUpdate();

        if (x > 0) {
            result = "Tender assigned successfully...";
        }

        return result;
    }

}
