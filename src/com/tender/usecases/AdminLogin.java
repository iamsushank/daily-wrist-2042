package com.tender.usecases;

import java.util.Scanner;

import com.tender.bean.Admin;
import com.tender.dao.AdminDao;
import com.tender.dao.AdminDaoImpl;
import com.tender.exceptions.AdminException;

public class AdminLogin {
	
	public static void back(String userName,String password) {
		Scanner in= new Scanner(System.in);
		AdminDao dao= new AdminDaoImpl();
		
		try {
			Admin admin= dao.adminLogin(userName, password);
			
			System.out.println("Welcome : " + admin.getAdminName());
			
			System.out.println("Select your option");
			System.out.println("1 to Register new vendor\n"
							 + "2 to View all vendors\n"
							 + "3 to Create new Tender\n"
							 + "4 to View all the Tenders\n"
							 + "5 to View all the bids of a tender\n"
							 + "6 to Assign tender to a vendor");
			
			int key= in.nextInt();
			
			int flag= 0;
			
			switch (key) {
			case 1: {
				new RegisterNewVendor().main(null);
				
				System.out.println("Press 9 to go back else press any other key");
				flag= in.nextInt();
				if(flag == 9) {
					AdminLogin.back(userName, password);
				}
				
				break;
			}
			case 2: {
				new ViewAllVendor().main(null);
				
				System.out.println("Press 9 to go back else press any other key");
				flag= in.nextInt();
				if(flag == 9) {
					AdminLogin.back(userName, password);
				}
				
				break;
			}
			case 3: {
				new CreateNewTender().main(null);
				
				System.out.println("Press 9 to go back else press any other key");
				flag= in.nextInt();
				if(flag == 9) {
					AdminLogin.back(userName, password);
				}
				
				break;
			}
			case 4: {
				new ViewTender().main(null);
				
				System.out.println("Press 9 to go back else press any other key");
				flag= in.nextInt();
				if(flag == 9) {
					AdminLogin.back(userName, password);
				}
				
				break;
			}
			case 5: {
				
				break;
			}
			case 6: {
				new AssignTender().main(null);;
				
				System.out.println("Press 9 to go back else press any other key");
				flag= in.nextInt();
				if(flag == 9) {
					AdminLogin.back(userName, password);
				}
				
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
			
			
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public static void main(String[] args) {
		
		Scanner in= new Scanner(System.in);
		
		System.out.println("Please enter username : ");
		String userName= in.next();
		
		System.out.println("Please enter password : ");
		String password= in.next();
		
		back(userName, password);
		
	}

}
