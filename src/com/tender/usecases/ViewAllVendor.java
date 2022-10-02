package com.tender.usecases;

import java.util.List;
import java.util.Scanner;

import com.tender.bean.Vendor;
import com.tender.dao.VendorDao;
import com.tender.dao.VendorDaoImpl;
import com.tender.exceptions.VendorException;

public class ViewAllVendor {

	public static void main(String[] args) {
		
		Scanner in= new Scanner(System.in);
		
		VendorDao dao= new VendorDaoImpl();
		
		try {
			List<Vendor> vendorList= dao.viewAllVendor();
			
			System.out.printf("%3s %6s %10s %15s %10s %15s %20s \n", "VendorId", "Password", "Name", "Address", "Phone", "Email", "Company");
			System.out.println("=============================================================================================");
			vendorList.forEach(v -> {
				System.out.printf("%3s %12s %15s %11s %11s %20s %14s \n",v.getVid(),v.getPassword(),v.getName(),v.getAddress(),v.getPhone(),v.getEmail(),v.getCompanyName());
			});
			
			System.out.println("=============================================================================================");
			
		} catch (VendorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
