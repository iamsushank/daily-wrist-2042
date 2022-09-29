package com.tender.usecases;

import java.util.Scanner;

import com.tender.bean.Vendor;
import com.tender.dao.VendorDao;
import com.tender.dao.VendorDaoImpl;
import com.tender.exceptions.VendorException;

public class AdminLogin {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter userId : ");
		int userID= in.nextInt();
		
		System.out.println("Please enter password : ");
		String password= in.next();
		
		VendorDao dao= new VendorDaoImpl();
		
		try {
			Vendor vendor= dao.loginStudent(userID, password);
			
			System.out.println("Welcome : " + vendor.getName());
			
		} catch (VendorException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	
}
