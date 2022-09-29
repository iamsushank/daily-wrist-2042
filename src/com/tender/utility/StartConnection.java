package com.tender.utility;

import java.sql.Connection;

public class StartConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection conn=DBUtility.provideConnection();
		
		System.out.println(conn);

	}

}
