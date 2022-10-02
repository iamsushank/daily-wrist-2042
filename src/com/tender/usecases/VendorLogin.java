package com.tender.usecases;

import java.util.Scanner;

import com.tender.bean.Vendor;
import com.tender.dao.VendorDao;
import com.tender.dao.VendorDaoImpl;
import com.tender.exceptions.VendorException;

public class VendorLogin {
	
	public static void main(String[] args) {
		
		Scanner in= new Scanner(System.in);
		
		System.out.println("Please enter userId : ");
		int userID= in.nextInt();
		
		System.out.println("Please enter password : ");
		String password= in.next();
		
		VendorDao dao= new VendorDaoImpl();
		
		try {
			Vendor vendor= dao.loginVendor(userID, password);
			
			System.out.println("Welcome : " + vendor.getName());
			
			System.out.println("Select your option");
			System.out.println("1 to View all the current Tenders\n"
							 + "2 to Place a Bid against a Tender\n"
							 + "3 to View status of a Bid(Whether Selected or Not)\n"
							 + "4 to View his own Bid History");
			
			int key= in.nextInt();
			
			switch (key) {
			case 1: {
				new ViewCurrentTenders().main(args);
				break;
			}
			case 2: {
				new BidTender().main(args);
				break;
			}
			case 3: {
				new BidStatus().main(args);
				break;
			}
			case 4: {
				new UserHistory().main(args);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
			
			
		} catch (VendorException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
