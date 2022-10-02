package com.tender.dao;


import java.util.List;

import com.tender.bean.Vendor;
import com.tender.exceptions.VendorException;

public interface VendorDao {
	
	public void vendorHistory(int vid, String password);

	public Vendor loginVendor(int userID, String password) throws VendorException;
	
	public String registerVendor(Vendor vendor) throws VendorException;
	
	public List<Vendor> viewAllVendor() throws VendorException;
	
	public void viewCurrentTenders(int vid) throws VendorException;
	
}
