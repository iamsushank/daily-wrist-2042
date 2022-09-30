package com.tender.usecases;

import java.util.Scanner;

import com.tender.bean.Bid;
import com.tender.dao.BidDao;
import com.tender.dao.BidDaoImpl;
import com.tender.exceptions.BidException;

public class BidTender {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter tender id : ");
		int tid= in.nextInt();
		
		System.out.println("Please enter amount : ");
		int amount= in.nextInt();
		
		System.out.println("Please enter vendor id : ");
		int vid= in.nextInt();
		
		BidDao bids= new BidDaoImpl();
		
		Bid bid= new Bid();
		bid.setTid(tid);
		bid.setAmount(amount);
		bid.setVid(vid);
		
		String result = null;
		try {
			result = bids.placeABid(bid);
		} catch (BidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(result);
		
	}

}
