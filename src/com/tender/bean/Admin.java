package com.tender.bean;

public class Admin {
	
	private int adminId;
	private String adminUName; 
	private String adminPassword; 
	private String adminName;
	
	
	public Admin() {}


	public Admin(int adminId, String adminUName, String adminPassword, String adminName) {
		super();
		this.adminId = adminId;
		this.adminUName = adminUName;
		this.adminPassword = adminPassword;
		this.adminName = adminName;
	}


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public String getAdminUName() {
		return adminUName;
	}


	public void setAdminUName(String adminUName) {
		this.adminUName = adminUName;
	}


	public String getAdminPassword() {
		return adminPassword;
	}


	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}


	public String getAdminName() {
		return adminName;
	}


	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}


	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminUName=" + adminUName + ", adminPassword=" + adminPassword
				+ ", adminName=" + adminName + "]";
	}
	
	
	
}
