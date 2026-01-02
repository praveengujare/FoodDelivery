package com.tap.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {

	
	private static final String URL = "jdbc:mysql://localhost:3306/fooddelevery";
	private static final String USER = "root";
	private static final String PASSWORD = "Pooj555"; 

	
	public static Connection connection ;

	public static Connection connectDb(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			 connection = DriverManager.getConnection(URL , USER , PASSWORD );
			 
			 System.out.println("connected to databases");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		 
		return connection;
		
	}
}
