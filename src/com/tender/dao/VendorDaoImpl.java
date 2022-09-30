package com.tender.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tender.bean.Tender;
import com.tender.bean.Vendor;
import com.tender.exceptions.TenderException;
import com.tender.exceptions.VendorException;
import com.tender.utility.DBUtility;

public class VendorDaoImpl implements VendorDao{

	@Override
	public Vendor loginStudent(int userID, String password) throws VendorException {
		// TODO Auto-generated method stub
		Vendor vendor = null;
		
		try (Connection conn= DBUtility.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("SELECT * FROM vendor where vid=? AND password=?");
			
			ps.setInt(1, userID);
			ps.setString(2, password);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {
				int id= rs.getInt("vid");
				String name= rs.getString("vname");
				String pass= rs.getString("password");
				String add= rs.getString("address");
				String phone= rs.getString("phone");
				String email= rs.getString("email");
				String comp= rs.getString("comp");
				
				vendor= new Vendor(id,pass,name,add,phone,email,comp);
			}else
				throw new VendorException("Invalid username or password");
			
			
			
		} catch (Exception e) {
			throw new VendorException(e.getMessage());
		}
		
		return vendor;
	}
	
	
}
