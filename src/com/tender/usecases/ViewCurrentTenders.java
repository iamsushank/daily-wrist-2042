package com.tender.usecases;

import java.util.Scanner;

import com.tender.dao.VendorDao;
import com.tender.dao.VendorDaoImpl;
import com.tender.exceptions.VendorException;

public class ViewCurrentTenders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in= new Scanner(System.in);
		
		System.out.println("Please enter your vendor id : ");
		int vid= in.nextInt();
		
		VendorDao dao= new VendorDaoImpl();
		
		try {
			dao.viewCurrentTenders(vid);
		} catch (VendorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
