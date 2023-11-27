package com.railworld.Util;

import com.railworld.bean.Admin;
import com.railworld.bean.Bidder;
import com.railworld.bean.Tender;
import com.railworld.bean.Vendor;
import com.railworld.dao.*;
import com.railworld.exception.BidderException;
import com.railworld.exception.TenderException;
import com.railworld.exception.VendorException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MethodUtil {
    AdminDao ad = new AdminDaoImpl();
    VendorDao vd = new VendorDaoImpl();
    TenderDao td = new TenderDaoImpl();
    BidderDao bd = new BidderDaoImpl();

    public boolean LogInAdmin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("Enter the ID here:-");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Password here:-");
        String password = sc.nextLine();

        try {
            Admin admin = ad.logInAdmin(id, password);
            System.out.println();
            System.out.println();
            System.out.println("Welcome, " + admin.getName() + "!");
            return true;
        } catch (Exception e) {
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean LogInVendor() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("Enter the ID here:-");
        int id = sc.nextInt();

        try {
            Vendor vendor = vd.logInVendor(id);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Welcome, " + vendor.getName() + "!");
            return true;
        } catch (VendorException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void RegisterVendor() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("Enter a id here:-");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter a name here:-");
        String name = sc.nextLine();
        System.out.println("Enter a mobile number here:-");
        int mobile = sc.nextInt();
        System.out.println("Enter a email here:-");
        String email = sc.nextLine();
        System.out.println("Enter a address here:-");
        String address = sc.nextLine();
        System.out.println("Enter a company name here:-");
        String company = sc.nextLine();

        try {
            String result = vd.registerVendor(id, name,mobile, email, address,company);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(result);
        } catch (VendorException e) {
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage());
        }
    }
    public void ViewAllVendor() throws SQLException {

        System.out.println("--------------------------------");
        try {
            List<Vendor> vendors = vd.viewAllVendor();
            System.out.println();
            System.out.println();
            vendors.forEach(System.out::println);
        } catch (VendorException e) {
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    public void CreateTender() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("Enter a id here :-");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter a name here:-");
        String name = sc.nextLine();
        System.out.println("Enter a type here:-");
        String type = sc.nextLine();
        System.out.println("Enter a price here:-");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter a location here:-");
        String location = sc.nextLine();

        try {
            String result = td.createTender(id, name, type, price, location);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(result);
        } catch (TenderException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    public void ViewAllTender() throws SQLException {

        System.out.println("--------------------------------");
        try {
            List<Tender> vendors = td.viewAllTender();
            System.out.println();
            System.out.println();
            System.out.println();
            vendors.forEach(System.out::println);
        } catch (TenderException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    public void ViewAllBidsOfTender() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("Enter the tender ID here :-");
        int tid = sc.nextInt();

        try {
            List<Bidder> bidders = bd.viewAllBidsOfTender(tid);
            System.out.println();
            System.out.println();
            System.out.println();
            bidders.forEach(System.out::println);
        } catch (BidderException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    public void AssignTenderToVendor() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("Enter the Vendor ID here :-");
        int vid = sc.nextInt();
        System.out.println("Enter the Tender ID here :-");
        int tid = sc.nextInt();


        try {
            String result = td.assignTenderToVendor(vid, tid);
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(result);
        } catch (BidderException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    public void ViewCurrentTender() throws SQLException {

        System.out.println("--------------------------------");
        try {
            List<Tender> vendors = td.viewAllTender();
            System.out.println();
            System.out.println();
            vendors.forEach(System.out::println);
        } catch (TenderException e) {
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    public void PlaceBidAgainstTender() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("Enter the Vendor ID  here:-");
        int venId = sc.nextInt();
        System.out.println("Enter the Tender ID  here:-");
        int tenId = sc.nextInt();
        System.out.println("Enter the Bidding price here:-");
        int bPrice = sc.nextInt();
        sc.nextLine();

        try {
            String result = bd.placeBidAgainstTender(venId, tenId, bPrice);
            System.out.println();
            System.out.println();
            System.out.println(result);
        } catch (TenderException e) {
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    public void ViewStatusOfBid() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------");
        System.out.println("Enter the Bid S. No. here:-");
        int id = sc.nextInt();

        try {
            Bidder bidder = bd.viewStatusOfBid(id);
            System.out.println();
            System.out.println();
            System.out.println(bidder.getStatus());
        } catch (BidderException e) {
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage());
        }
    }

    public void ViewOwnBidHistory() throws SQLException {
        System.out.println("--------------------------------");
        try {
            List<Bidder> bidders = bd.viewOwnBidHistory();
            System.out.println();
            System.out.println();
            bidders.forEach(b -> System.out.println(b));
        } catch (BidderException e) {
            System.out.println();
            System.out.println();
            System.out.println(e.getMessage());
        }
    }
}
