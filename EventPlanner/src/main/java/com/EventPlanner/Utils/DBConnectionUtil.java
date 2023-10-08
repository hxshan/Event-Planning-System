package com.EventPlanner.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {
	
	private static Connection connection;
	
	
	private DBConnectionUtil() {}
	
	public static Connection getDBConnection() {
		
		try {
			if(connection == null || connection.isClosed()) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/testsignup","root","GGsl@1974");
			}
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
	}

}
