package com.railworld.dao;

import com.railworld.bean.Admin;
import com.railworld.connection.DB;
import com.railworld.exception.AdminException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdminDaoImpl implements AdminDao{
    private final Connection con;

    public AdminDaoImpl() {
        this.con = DB.getConnection();
    }

    @Override
    public Admin logInAdmin(int id, String password) throws SQLException, AdminException {
        Admin result = null;

        PreparedStatement ps = this.con.prepareStatement("select * from admin where userId=? AND password=?");
        ps.setInt(1, id);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            String n = rs.getString("userName");
            String e = rs.getString("userEmail");
            result = new Admin(n, e);

        } else {
            throw new AdminException("Invalid Admin !");
        }
        return result;
    }
}
