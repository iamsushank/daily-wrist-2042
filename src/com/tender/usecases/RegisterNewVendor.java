package com.tender.usecases;

import java.util.Scanner;

import com.tender.bean.Vendor;
import com.tender.dao.AdminDao;
import com.tender.dao.AdminDaoImpl;
import com.tender.exceptions.AdminException;

public class RegisterNewVendor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in= new Scanner(System.in);
		
		System.out.println("Please enter the vendor details : ");
		
		System.out.println("Enter vendor id ");
		int vid= in.nextInt();
		
		System.out.println("Set vendor password ");
		String password= in.next();
		
		in.nextLine();
		
		System.out.println("Enter vendor name");
		String name= in.nextLine();

		System.out.println("Enter vendor address");
		String address= in.next();
		
		System.out.println("Enter vendor phone number");
		String phone_number= in.next();
		
		System.out.println("Enter vendor email");
		String email= in.next();
		
		System.out.println("Enter vendor company");
		String company= in.next();
		
		Vendor vendor = new Vendor(vid,password,name,address,phone_number,email,company);
		
		AdminDao dao= new AdminDaoImpl();
		
		try {
			dao.registerNewVendor(vendor);
			
			System.out.println("Vendor registerd successfully");
			
		} catch (AdminException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
