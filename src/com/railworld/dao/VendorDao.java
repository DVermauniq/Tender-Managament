package com.railworld.dao;


import com.railworld.bean.Vendor;
import com.railworld.exception.VendorException;

import java.sql.SQLException;
import java.util.List;


public interface VendorDao {
    public Vendor logInVendor(int id) throws VendorException, SQLException;
    public String registerVendor(int id, String name,int mobile, String email, String address,String company) throws VendorException, SQLException;

    public List<Vendor> viewAllVendor() throws VendorException, SQLException;
}
