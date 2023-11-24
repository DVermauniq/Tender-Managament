package com.railworld.model;

public class VendorBean {

	private int tid;
	private String name;
	private String email;
	private String address;
	private String companyName;
	private int mobNo;
	
	
	public VendorBean(int tid, String name, String email, String address, String companyName, int mobNo) {
		this.tid = tid;
		this.name = name;
		this.email = email;
		this.address = address;
		this.companyName = companyName;
		this.mobNo = mobNo;
	}
	


	@Override
	public String toString() {
		return "VendorBean [tid=" + tid + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", companyName=" + companyName + ", mobNo=" + mobNo + "]";
	}

	


	public VendorBean() {
		
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public int getMobNo() {
		return mobNo;
	}


	public void setMobNo(int mobNo) {
		this.mobNo = mobNo;
	}
	
}
