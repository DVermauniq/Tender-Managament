package com.railworld.model;

public class BidderBean {

	private int BidderId;
	private String name, email, companyName,contact;
	
	public BidderBean(int BidderId, String name,String email, String companyName,String contact) {
		this.name=name;
		this.BidderId=BidderId;
		this.email=email;
		this.companyName=companyName;
		this.contact=contact;
	}
	public BidderBean() {
		
	}
	@Override
	public String toString() {
		return "BidderBean [BidderId=" + BidderId + ", name=" + name + ", email=" + email + ", companyName="
				+ companyName + ", contact=" + contact + "]";
	}
	public int getBidderId() {
		return BidderId;
	}
	public void setBidderId(int bidderId) {
		BidderId = bidderId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
}
