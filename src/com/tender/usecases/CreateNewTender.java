package com.tender.usecases;

import java.util.Scanner;
import com.tender.bean.Tender;
import com.tender.dao.TenderDao;
import com.tender.dao.TenderDaoImpl;
import com.tender.exceptions.TenderException;

public class CreateNewTender {

	public static void main(String[] args) {
		
		Scanner in= new Scanner(System.in);
		
		System.out.println("Enter tender id : ");
		int tenderId= in.nextInt();
		
		System.out.println("Enter tender name : ");
		String tenderName= in.next();
		
		System.out.println("Enter tender type : ");
		String tenderType= in.next();
		
		System.out.println("Enter tender amount : ");
		int tenderAmount= in.nextInt();
		
		System.out.println("Enter tender location : ");
		String tenderLocation= in.next();
		
		System.out.println("Set tender deadline in yyyy-mm-dd : ");
		String tenderDealine= in.next();
		
		
		TenderDao dao= new TenderDaoImpl();
		
		Tender tender= new Tender();
		tender.setTid(tenderId);
		tender.settName(tenderName);
		tender.setType(tenderType);
		tender.setAmount(tenderAmount);
		tender.setLocation(tenderLocation);
		tender.setDeadline(tenderDealine);
		
		String result = null;
		try {
			result= dao.createNewTender(tender);
		} catch (TenderException e) {
			e.printStackTrace();
		}
		
		System.out.println(result);
		
	}

}
