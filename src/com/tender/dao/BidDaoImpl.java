package com.tender.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			ps.setDate(4, bid.getDeadline());
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
	
	
	@Override
	public String viewStatus(int id) throws BidException {
		
		int flag= 0;
		
		try (Connection conn= DBUtility.provideConnection()){

			PreparedStatement ps= conn.prepareStatement
					("SELECT * FROM vendor.bid WHERE bid= ?");
			
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				flag= rs.getInt("flag");
				
				
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(flag == 0) 
			return "Bid not accepted";
		else
			return "Bid accepted";
		
	}


	@Override
	public void assignTender(int tenderId) throws BidException {
		
try(Connection conn= DBUtility.provideConnection()) {
	
	String message= "No tender assigned";
	
	PreparedStatement ps1= conn.prepareStatement
			("SELECT b.bid,t.tid,v.vid,t.tName,v.vname, MAX(b.amount) as accepted_bid, b.bid_date,b.flag FROM bid b, vendor v, tender t WHERE b.vid = v.vid AND t.tid=b.tid AND t.tid = ?");
	ps1.setInt(1, tenderId);
	ResultSet rs1 = ps1.executeQuery();
	
	if(rs1.next()){
		
		int bid= rs1.getInt("bid");
//		System.out.println(bid);
		
		int tid= rs1.getInt("tid");
//		System.out.println(tid);
		
		int vid= rs1.getInt("vid");
//		System.out.println(vid);
		
		String tName= rs1.getString("tName");
//		System.out.println(tName);
		
		String vname= rs1.getString("vname");
//		System.out.println(vname);
		
		int amount= rs1.getInt("accepted_bid");
//		System.out.println(amount);
		
		Date bid_date= rs1.getDate("bid_date");
//		String date= bid_date.toString();
//		System.out.println(date);
		
		int flag= rs1.getInt("flag");
//		System.out.println(flag);
		
//		System.out.println(rs1.getInt(bid));
		
		PreparedStatement ps2= conn.prepareStatement
				("UPDATE bid set flag = 1 where bid.bid = ?");
		ps2.setInt(1, bid);
		
		ps2.executeUpdate();
		
		message= "Tender "+tName+ " assigned to " + vname +" successfully";
	}
	System.out.println(message);
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
