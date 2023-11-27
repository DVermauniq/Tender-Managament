package com.railworld.dao;

import com.railworld.bean.Vendor;
import com.railworld.connection.DB;
import com.railworld.exception.VendorException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDaoImpl  implements VendorDao{
    int master_id;

    private Connection con;

    public VendorDaoImpl() {
        this.con = DB.getConnection();
    }

    @Override
    public Vendor logInVendor(int id) throws SQLException, VendorException {
        this.master_id = id;

        Vendor vendor = null;

        PreparedStatement ps = this.con.prepareStatement("select * from Vendor where id=? ");

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
           int i= rs.getInt("id");
            String n = rs.getString("name");
            int m=rs.getInt("mobile");
            String e = rs.getString("email");
            String a = rs.getString("address");
            String c=rs.getString("company");


            vendor = new Vendor(i, n,m, e, a,c);
        } else {
            throw new VendorException("Invalid credentials!");
        }

        return vendor;
    }
    @Override
    public String registerVendor(int id, String name,int mobile, String email, String address,String company)
            throws  SQLException {
        String result = "Insertion failed!";

        PreparedStatement ps = this.con.prepareStatement("insert into Vendor values(?,?,?,?,?,?)");

        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setInt(3,mobile);
        ps.setString(4, email);
        ps.setString(5, address);
        ps.setString(6,company);

        int x = ps.executeUpdate();

        if (x > 0) {
            result = "Insertion successfully.";
        }

        return result;
    }

    @Override
    public List<Vendor> viewAllVendor() throws VendorException, SQLException {
        List<Vendor> vendors = new ArrayList<>();

        PreparedStatement ps = this.con.prepareStatement("select * from Vendor");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int i = rs.getInt("id");
            String n = rs.getString("name");
            int m=rs.getInt("mobile");
            String e = rs.getString("email");
            String a = rs.getString("address");
            String c=rs.getString("company");

            vendors.add(new Vendor(i, n, m, e, a,c));
        }

        if (vendors.size() == 0) {
            throw new VendorException("No vendor found!");
        }

        return vendors;
    }
}
