package com.tender.bean;

public class Vendor {
	
	private int vid;
	private String password;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String companyName;
	
	
	public Vendor() {}


	public Vendor(int vid, String password, String name, String address, String phone, String email,
			String companyName) {
		super();
		this.vid = vid;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.companyName = companyName;
	}


	public int getVid() {
		return vid;
	}


	public void setVid(int vid) {
		this.vid = vid;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
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


	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", password=" + password + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", email=" + email + ", companyName=" + companyName + "]";
	}
	
	
	
}
