package com.tender.usecases;

import java.util.List;

import com.tender.bean.Tender;
import com.tender.dao.TenderDao;
import com.tender.dao.TenderDaoImpl;
import com.tender.exceptions.TenderException;

public class ViewTender {
	
	public static void main(String[] args) {
		
		TenderDao tender= new TenderDaoImpl();
		
		try {
			List<Tender> tenders= tender.viewAllTenderDetails();
			
			tenders.forEach(t -> {
				
				System.out.println("Tender id : " + t.getTid());
				System.out.println("Tender name : " + t.gettName());
				System.out.println("Tender amount : " + t.getAmount());
				System.out.println("Tender type : " + t.getType());
				System.out.println("Tender location : " + t.getLocation());
				System.out.println("==============================================");
				
			});
			
		} catch (TenderException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
}
