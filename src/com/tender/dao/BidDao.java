package com.tender.dao;

import com.tender.bean.Bid;
import com.tender.exceptions.BidException;

public interface BidDao {
	
	public String placeABid(Bid bid) throws BidException;
	
	public String viewStatus(int bid) throws BidException;
	
	public void assignTender(int tenderId) throws BidException;
	
}
