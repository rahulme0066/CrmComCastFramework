package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;
	public void getDBConnection(String url,String username,String password) {
		try {
			Driver driver1=new Driver();
			DriverManager.registerDriver(driver1);
			 conn = DriverManager.getConnection(url,username,password);
			
		}
		catch(Exception e){
			
		}
		
	}
	public void closeDbConnection() {
		try {
			conn.close();
		}
		catch(Exception e) {
			
		}
	}

}
