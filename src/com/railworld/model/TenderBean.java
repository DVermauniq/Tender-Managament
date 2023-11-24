package com.railworld.model;
import java.util.*;

public class TenderBean {

	private int tid;
	private String name;
	private String type;
	private int price;
	private String location;
	private Date deadline = new Date();
	
	
	public TenderBean(int tid, String name, String type, int price, String location, Date deadline) {
		super();
		this.tid = tid;
		this.name = name;
		this.type = type;
		this.price = price;
		this.location = location;
		this.deadline = deadline;
	}
	
	public TenderBean() {
		
		// TODO Auto-generated constructor stub
	}

	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	@Override
	public String toString() {
		return "tender [tid=" + tid + ", name=" + name + ", type=" + type + ", price=" + price + ", location="
				+ location + ", deadline=" + deadline + "]";
	}
}
