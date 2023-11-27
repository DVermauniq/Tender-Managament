package com.railworld.dao;

import com.railworld.bean.Admin;
import com.railworld.exception.AdminException;
import java.sql.SQLException;


public interface AdminDao {
    public Admin logInAdmin(int id, String password) throws AdminException, SQLException;

}
