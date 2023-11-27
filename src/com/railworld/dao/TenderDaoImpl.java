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

        PreparedStatement ps = this.con.prepareStatement("select * from Tender");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int i = rs.getInt("id");
            String n = rs.getString("name");
            String t = rs.getString("type");
            int p = rs.getInt("price");
            String l = rs.getString("location");

            tenders.add(new Tender(i, n, t, p, l));
        }

        if (tenders.size() == 0) {
            throw new TenderException("No vendor found!");
        }

        return tenders;
    }

    @Override
    public String createTender(int id, String name, String type, int price, String location)
            throws  SQLException {

        String result = "Tender creation failed";

        PreparedStatement ps = this.con.prepareStatement("insert into Tender values(?,?,?,?,?)");

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, type);
        ps.setInt(4, price);
        ps.setString(5, location);

        int x = ps.executeUpdate();
        if (x > 0) {
            result = "Tender created successfully.";
        }

        return result;
    }


    @Override
    public String assignTenderToVendor(int venId, int tenId) throws  SQLException {
        String result = "Invalid details provided!";

        PreparedStatement ps = this.con
                .prepareStatement("update Bidder set status = 'selected' where venId=? AND tenId=?");

        ps.setInt(1, venId);
        ps.setInt(2, tenId);

        int x = ps.executeUpdate();

        if (x > 0) {
            result = "Tender assigned successfully...";
        }

        return result;
    }

}
