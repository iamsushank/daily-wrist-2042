package com.tender.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tender.bean.Admin;
import com.tender.bean.Vendor;
import com.tender.exceptions.AdminException;
import com.tender.exceptions.VendorException;
import com.tender.utility.DBUtility;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin adminLogin(String userName, String password) throws AdminException {
		
		Admin admin= null;
		
try (Connection conn= DBUtility.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("SELECT * FROM admin where adminUName=? AND adminPassword=?");
			
			ps.setString(1, userName);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				
				int id= rs.getInt("adminId");
				String aUName= rs.getString("adminUName");
				String aPass= rs.getString("adminPassword");
				String name= rs.getString("adminName");
				
				admin= new Admin(id,aUName,aPass,name);
				
			}else
				throw new VendorException("Invalid username or password");
			
			
			
		} catch (Exception e) {
			throw new AdminException(e.getMessage());
		}
		
		return admin;
		
	}

	@Override
	public String registerNewVendor(Vendor vendor) throws AdminException {
		
		String message = "Not Inserted something went wrong";
		
		try (Connection conn= DBUtility.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("INSERT INTO vendor values(?,?,?,?,?,?,?)");
			
			ps.setInt(1, vendor.getVid());
			ps.setString(2, vendor.getPassword());
			ps.setString(3, vendor.getName());
			ps.setString(4, vendor.getAddress());
			ps.setString(5, vendor.getPhone());
			ps.setString(6, vendor.getEmail());
			ps.setString(7, vendor.getCompanyName());
			
			int x= ps.executeUpdate();
			
			if(x > 0) {
				message = "Vendor Inserted successfully";
			}
			
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}
	
	
	
}
