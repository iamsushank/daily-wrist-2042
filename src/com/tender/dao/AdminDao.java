package com.tender.dao;

import com.tender.bean.Admin;
import com.tender.bean.Vendor;
import com.tender.exceptions.AdminException;

public interface AdminDao {
	
	public Admin adminLogin(String userName, String password) throws AdminException;
	
	public String registerNewVendor(Vendor vendor)throws AdminException;
	
}
