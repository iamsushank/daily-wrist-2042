package com.tender.dao;

import java.util.List;

import com.tender.bean.Tender;
import com.tender.exceptions.TenderException;

public interface TenderDao {
	
	public List<Tender> viewAllTenderDetails() throws TenderException;
	
	public String createNewTender(Tender tender) throws TenderException;
	
	
	
}
