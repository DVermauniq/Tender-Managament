package com.railworld.Util;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrinterUtil {
    static Scanner sc = new Scanner(System.in);
    static MethodUtil obj = new MethodUtil();


    public static void main(String[] args) throws SQLException {

        System.out.println("WELCOME TO THE TENDER APPLICATION");
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println("Please enter a valid input to do the following operations:-");
        System.out.println("1. Administrator");
        System.out.println("2. Vendor");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("99. Exit the application");
        int input = sc.nextInt();
        switch (input) {
            case 1 -> {
                System.out.println("Please enter your admin id and password to login:-");
                if (obj.LogInAdmin()) {
                    administratorMain();
                }else {
                    System.out.println("Invalid input");
                    obj.LogInAdmin();
                }
            }
            case 2 -> {
                System.out.println("Please enter your vendor id  login:-");
                if (obj.LogInVendor()) {
                    vendorMain();
                }
               else {
                    System.out.println("Invalid input");
                    obj.LogInVendor();
                }
            }
            case 99 -> {
                System.out.println("Thanks for visiting ,");
                System.out.println("Have a great day.....!!");
            }
            default -> System.out.println("Please enter a valid input");
        }
    }
    public static void administratorMain() throws SQLException {

        System.out.println("--------------------------------");
        System.out.println("1. Register a new vendor");
        System.out.println("2. View all the vendors");
        System.out.println("3. Create a new tender");
        System.out.println("4. View all the tenders");
        System.out.println("5. View all the bids of a tender");
        System.out.println("6. Assign tender to a vendor");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("0. Logout");
        System.out.println("99. Exit the application");
        int input1 = sc.nextInt();
        switch (input1) {
            case 0:
                System.out.println("Logout Successfully...");
                MenuPrinterUtil.main(null);
                break;

            case 1:
                obj.RegisterVendor();
                MenuPrinterUtil.administratorMain();
                break;

            case 2:
                obj.ViewAllVendor();
                MenuPrinterUtil.administratorMain();
                break;

            case 3:
                obj.CreateTender();
                MenuPrinterUtil.administratorMain();
                break;

            case 4:
                obj.ViewAllTender();
                MenuPrinterUtil.administratorMain();
                break;

            case 5:
                obj.ViewAllBidsOfTender();
                MenuPrinterUtil.administratorMain();
                break;

            case 6:
                obj.AssignTenderToVendor();
                MenuPrinterUtil.administratorMain();
                break;

            case 99:
                System.out.println("Thanks for visiting,");
                System.out.println("Have a great day.....!!");
                return;

            default:
                System.out.println("Please enter a valid input!");
                MenuPrinterUtil.administratorMain();
        }
    }

    public static void vendorMain() throws SQLException {

        System.out.println("--------------------------------");
        System.out.println("1. View all the current tenders");
        System.out.println("2. Place a bid against a tender");
        System.out.println("3. View status of bid");
        System.out.println("4. View the bid history");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("0. Logout");
        System.out.println("99. Exit the application");
        int input2 = sc.nextInt();
        switch (input2) {
            case 0 -> {
                System.out.println("Logout successfully...");
                MenuPrinterUtil.main(null);
            }
            case 1 -> {
                obj.ViewCurrentTender();
                MenuPrinterUtil.vendorMain();
            }
            case 2 -> {
                obj.PlaceBidAgainstTender();
                MenuPrinterUtil.vendorMain();
            }
            case 3 -> {
                obj.ViewStatusOfBid();
                MenuPrinterUtil.vendorMain();
            }
            case 4 -> {
                obj.ViewOwnBidHistory();
                MenuPrinterUtil.vendorMain();
            }
            case 99 -> {
                System.out.println("Thanks for visiting,");
                System.out.println("Have a great day.....!!");
            }
            default -> System.out.println("Please enter a valid input");
        }
    }
}
