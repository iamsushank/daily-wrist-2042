package com.tender.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tender.bean.Tender;
import com.tender.exceptions.TenderException;
import com.tender.utility.DBUtility;

public class TenderDaoImpl implements TenderDao{
	
	@Override
	public List<Tender> viewAllTenderDetails() throws TenderException {
		
		List<Tender> tenders= new ArrayList<>();
		
		try (Connection conn= DBUtility.provideConnection()){
			
//			PreparedStatement ps1= conn.prepareStatement("SELECT * FROM tender");
			
			PreparedStatement ps= conn.prepareStatement("SELECT * FROM tender");
			
			ResultSet rs= ps.executeQuery();
//			select datediff(?,current_date()) as date
			
			
			
			while(rs.next()) {
				
				int tid= rs.getInt("tid");
				String tName= rs.getString("tName");
				String type= rs.getString("type");
				int tamount= rs.getInt("tamount");
				String location= rs.getString("location");
				String deadline= rs.getString("deadline");
				
				Tender tender= new Tender(tid,tName,type,tamount,location,deadline);
				
				tenders.add(tender);
				
			}
			
		} catch (SQLException e) {
			throw new TenderException(e.getMessage());
		}
		
		if(tenders.size() == 0) {
			throw new TenderException("No tender found..");
		}
		
		
		return tenders;
	}

	@Override
	public String createNewTender(Tender tender) throws TenderException {
		
		String message= "No new tender created yet...";
		
		try (Connection conn= DBUtility.provideConnection()){
		
			PreparedStatement ps= conn.prepareStatement("INSERT INTO tender values(?,?,?,?,?,?)");
			
			ps.setInt(1, tender.getTid());
			ps.setString(2, tender.gettName());
			ps.setString(3, tender.getType());
			ps.setInt(4, tender.getAmount());
			ps.setString(5, tender.getLocation());
			ps.setString(6, tender.getDeadline());
			
			int x= ps.executeUpdate();
			
			if(x > 0) {
				message = "Added new tender successfully";
			}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return message;
	}
	
}
