package com.tender.usecases;

import java.util.Scanner;

import com.tender.dao.BidDao;
import com.tender.dao.BidDaoImpl;
import com.tender.exceptions.BidException;

public class BidStatus {

	public static void main(String[] args) {
		
		Scanner in= new Scanner(System.in);
		
		System.out.println("Enter bid id for checking status : ");
		int id= in.nextInt();
		
		BidDao dao= new BidDaoImpl();
		
		try {
			String bid= dao.viewStatus(id);
			
			System.out.println(bid);
			
		} catch (BidException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
