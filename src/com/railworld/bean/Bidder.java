package com.railworld.bean;

public class Bidder  {
    private int id;
    private int venId;
    private int tenId;
    private int price;
    private String status;


    public Bidder(int id, int venId, int tenId, int price, String status) {
        this.id = id;
        this.venId = venId;
        this.tenId = tenId;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVenId() {
        return venId;
    }

    public void setVenId(int venId) {
        this.venId = venId;
    }

    public int getTenId() {
        return tenId;
    }

    public void setTenId(int tenId) {
        this.tenId = tenId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bidder{" +
                "bidId=" + id +
                ", venId=" + venId +
                ", tenId=" + tenId +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
