package com.tender.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

import com.tender.bean.Bid;
import com.tender.exceptions.BidException;
import com.tender.utility.DBUtility;

public class BidDaoImpl implements BidDao{

	@Override
	public String placeABid(Bid bid) throws BidException {
		
		String message= "Not inserted...";
		
		try(Connection conn= DBUtility.provideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement
					("INSERT INTO bid(tid,amount,vid,bid_date) values(?,?,?,?)");
			
			ps.setInt(1, bid.getTid());
			ps.setInt(2, bid.getAmount());
			ps.setInt(3, bid.getVid());
			ps.setDate(4, getCurrentDate());
			int x = ps.executeUpdate();
			if(x > 0) {
				message = "Bid placed sucessfully";
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return message;
	}
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	
	
	@Override
	public String viewStatus(int bid) throws BidException {
		
		int flag= 0;
		
		try (Connection conn= DBUtility.provideConnection()){
			
			PreparedStatement ps= conn.prepareStatement
					("SELECT * FORM bid WHERE `bid`= ?");
			
			ps.setInt(1, bid);
			
			ResultSet rs = ps.executeQuery();
			System.out.println("sdfg");
			if(rs.next()) {
				
				flag= rs.getInt("check");
				
				System.out.println("check ====> "+flag);
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(flag == 0) 
			return "Bid not accepted";
		else
			return "Bid accepted";
		
	}
	
	
}
