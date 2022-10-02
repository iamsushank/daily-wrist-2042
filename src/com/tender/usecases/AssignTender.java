package com.tender.usecases;

import java.util.Scanner;

import com.tender.dao.BidDao;
import com.tender.dao.BidDaoImpl;
import com.tender.exceptions.BidException;

public class AssignTender {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		
		System.out.println("Please enter the tender id which you want to assing tender for : ");

		int tid= in.nextInt();
		
		BidDao dao= new BidDaoImpl();
		
		try {
			dao.assignTender(tid);
		} catch (BidException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
