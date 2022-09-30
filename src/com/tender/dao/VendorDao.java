package com.tender.dao;

import com.tender.bean.Vendor;
import com.tender.exceptions.VendorException;

public interface VendorDao {
	
	public Vendor loginStudent(int userID, String password) throws VendorException;
	
	
}
