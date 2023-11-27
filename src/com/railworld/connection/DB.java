package com.railworld.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class DB {

    private static String url = "jdbc:mysql://localhost:3306/ tender_management";
    private static String user = "root";
    private static String password = "root";
    private static Connection con;




    static{

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        return con;
    }
}









