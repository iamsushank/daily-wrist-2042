package com.execute.app;

import java.util.Scanner;

import com.tender.usecases.AdminLogin;
import com.tender.usecases.UserHistory;
import com.tender.usecases.VendorLogin;

public class StartApplication {

	public static void main(String[] args) {
		
		Scanner in= new Scanner(System.in);
		
		System.out.println("Welcome to Tender management System");
		System.out.println("Select from the below options \n"
				+ "Login as Administrator: press 1\n"
				+ "Login as Vendor: press 2");
		int login= in.nextInt();
		switch (login) {
		case 1: {
			AdminLogin al= new AdminLogin();
			al.main(args);
			break;
		}
		case 2: {
			new VendorLogin().main(args);;
			break;
		}
		default:
			System.out.println("Invalid entry");
		}
		

	}

}
