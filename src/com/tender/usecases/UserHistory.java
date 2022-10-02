package com.tender.usecases;

import java.util.List;
import java.util.Scanner;
import com.tender.bean.Vendor;
import com.tender.dao.VendorDao;
import com.tender.dao.VendorDaoImpl;
import com.tender.exceptions.VendorException;

public class UserHistory {

	public static void main(String[] args) {
		
		Scanner in= new Scanner(System.in);
		
		System.out.println("Enter vendor id : ");
		int vendorId= in.nextInt();
		
		System.out.println("Enter vendor password : ");
		String password= in.next();
		
		VendorDao dao = new VendorDaoImpl();
		
		
//		
//		try {
			dao.vendorHistory(vendorId, password);
//		List<Student> students= dao.getAllStudentDetails();
//		
//		students.forEach(s ->{
//			
//			System.out.println("Student Name :"+s.getName());
//			System.out.println("Student email: "+s.getEmail());
//			
//			System.out.println("=======================");
//		});
//		
//		}catch(VendorException ve) {
//			System.out.println(ve.getMessage());
//		}
		

	}

}
