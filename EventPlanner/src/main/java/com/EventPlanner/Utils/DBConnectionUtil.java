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
				connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_planner_db","root","GGsl@1974");
			}
		} catch (SQLException | ClassNotFoundException e) {
			
			ErrorLoggerUtil.logError("Database Connection Util:","Connection Failed", e);
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		
		try {
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {	
			ErrorLoggerUtil.logError("Database Connection Util:","Connection Failed", e);
		}
		
	}

}
