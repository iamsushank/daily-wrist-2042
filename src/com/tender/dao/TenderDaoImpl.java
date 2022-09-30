package com.tender.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			
			PreparedStatement ps= conn.prepareStatement("SELECT * FROM tender");
			
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()) {
				
				int tid= rs.getInt("tid");
				String tName= rs.getString("tName");
				String type= rs.getString("type");
				int tamount= rs.getInt("tamount");
				String location= rs.getString("location");
				Date deadline= rs.getDate("deadline");
				
				Tender tender= new Tender(tid,tName,type,tamount,location,deadline);
				
				tenders.add(tender);
				
			}
			
		} catch (Exception e) {
			throw new TenderException(e.getMessage());
		}
		
		if(tenders.size() == 0) {
			throw new TenderException("No tender found..");
		}
		
		
		return tenders;
	}
	
	
	
}
