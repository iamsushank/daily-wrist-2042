package com.tender.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tender.bean.Current;
import com.tender.bean.Vendor;
import com.tender.exceptions.VendorException;
import com.tender.utility.DBUtility;

public class VendorDaoImpl implements VendorDao{

	@Override
	public Vendor loginVendor(int userID, String password) throws VendorException {
		
		Vendor vendor= null;
		
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

	@Override
	public void vendorHistory(int vid, String password){
		
		List vendorsHis= new ArrayList<>();
		
		try(Connection conn= DBUtility.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("SELECT t.tName, t.tamount,v.vname,v.comp,b.amount FROM bid b, vendor v, tender t where b.vid=?  AND b.vid=v.vid AND t.tid=b.tid");
			
			ps.setInt(1, vid);
			
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				System.out.printf("%10s %10s %10s %10s %10s \n", rs.getString("t.tName"), rs.getInt("t.tamount"), (rs.getString("v.vname")), (rs.getString("v.comp")), (rs.getString("b.amount")));
					
			}
			
		} catch (SQLException e) {
//			throw new StudentException(e.getMessage());
		}
		
		
//		return vendorsHis;
	}

	
	
	
	
	
	
	@Override
	public String registerVendor(Vendor vendor) throws VendorException {
		
		String message= "No new vendor added";
		
		try(Connection conn= DBUtility.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("INSERT INTO vendor(vid,password,vname,address,phone,email,comp) values(?,?,?,?,?,?,?)");
			
			
			ps.setInt(1, vendor.getVid());
			ps.setString(2, vendor.getPassword());
			ps.setString(3, vendor.getName());
			ps.setString(4, vendor.getAddress());
			ps.setString(5, vendor.getPhone());
			ps.setString(6, vendor.getEmail());
			ps.setString(7, vendor.getCompanyName());
			int x = ps.executeUpdate();
			if(x > 0) {
				message = "Vendor added sucessfully";
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public List<Vendor> viewAllVendor() throws VendorException {
		
		List<Vendor> allVendor= new ArrayList<>();
		
		try(Connection conn= DBUtility.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("SELECT * FROM vendor");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int vid= rs.getInt("vid");
				String password= rs.getString("password");
				String vname= rs.getString("vname");
				String address= rs.getString("address");
				String phone= rs.getString("phone");
				String email= rs.getString("email");
				String comp= rs.getString("comp");
				
				Vendor vendor= new Vendor(vid,password,vname,address,phone,email,comp);
				
				allVendor.add(vendor);
				
			}
			
			
		}catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		
		return allVendor;
	}

	@Override
	public void viewCurrentTenders(int vid) throws VendorException {
		
		List<Current> allCurTenderList= new ArrayList<>();
		
try(Connection conn= DBUtility.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("SELECT b.bid,t.tid,v.vid,t.tName,v.vname, b.amount, b.bid_date,b.flag FROM bid b, vendor v, tender t WHERE v.vid = ? AND t.tid=b.tid AND flag = 1");
			ps.setInt(1, vid);
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				int tid= rs.getInt("tid");
				String tName= rs.getString("tName");
				String vname= rs.getString("vname");
				String amount= rs.getString("amount");
				
				
				Current current= new Current(tid,tName,vname,amount);
				
				allCurTenderList.add(current);
				
			}
			
			
		}catch (SQLException e) {
			throw new VendorException(e.getMessage());
		}
		
		allCurTenderList.forEach(c -> {
			System.out.printf("%s %s %s %s",c.getTid(), c.gettName(), c.getVname(), c.getAmount());
		});
		
	}	
	
}
