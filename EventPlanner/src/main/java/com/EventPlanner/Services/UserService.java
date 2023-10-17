package com.EventPlanner.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.EventPlanner.Models.User;
import com.EventPlanner.Utils.*;

public class UserService {
	//private static final Logger logger=LogManager.getLogger(UserService.class);
		public void addUser(User user) {
			Connection con = DBConnectionUtil.getDBConnection();
			
			String sql="insert into users(id,email,name,password,user_type_id)values(NULL,?,?,?,?);";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,user.getEmail());	
				stmt.setString(2,user.getName());
				stmt.setString(3,user.getPassword());	
				stmt.setInt(4,user.getUserTypeId());
				stmt.executeUpdate();
				stmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				//logger.error("Error: ",e);
				ErrorLoggerUtil.logError("UserService(addUser)","SQL ERROR: ", e);
				
			}finally {
				DBConnectionUtil.closeConnection(con);
			}
				
		}
		
		public boolean userExists(String email) {
			
			Connection con = DBConnectionUtil.getDBConnection();		
			String sql="select * from users where email=?";
			PreparedStatement stmt;
			boolean exists=false;
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1,email);
				ResultSet rs=stmt.executeQuery();
				
				if(rs.next()) {exists= true;}
				else {exists= false;}
				
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				ErrorLoggerUtil.logError("UserService(userExist)","SQL ERROR: ", e);
				//logger.error("Error: ",e);
			}finally{
				DBConnectionUtil.closeConnection(con);
				
			}
			return exists;
		}
		
		public User getUserDetails(String email) {
			Connection con = DBConnectionUtil.getDBConnection();		
			String sql="select * from users where email=?";
			User user=new User();
			try {
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setString(1,email);
				ResultSet rs=stmt.executeQuery();
				
				if(rs.next())
				{
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setUserTypeId(rs.getInt("user_type_id"));
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				ErrorLoggerUtil.logError("UserService(getuserDetails)","SQL ERROR: ", e);
				e.printStackTrace();
				//logger.error("Error: ",e);
			}finally{
				DBConnectionUtil.closeConnection(con);
				
			}
			
			return user;
		}
		public String getUserPassword(String email) {
			
			Connection con = DBConnectionUtil.getDBConnection();		
			String sql="select password from users where email=?";
			String password="";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,email);
				ResultSet rs=stmt.executeQuery();
				if(rs.next()) {
					password=rs.getString("password");
				}	
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				ErrorLoggerUtil.logError("UserService(getUserPassword)","SQL ERROR: ", e);
				//logger.error("Error: ",e);
			}finally{
				DBConnectionUtil.closeConnection(con);
				
			}
			return password;
		}
		
		
		
		
		public int getUserTypeId(String type){
				
			Connection con = DBConnectionUtil.getDBConnection();
			
			String sql="select id from user_types where type=?";
			int typeid = 0;
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,type);
				ResultSet rs=stmt.executeQuery();
				if(rs.next()) {
					typeid=rs.getInt("id");
				}	
				rs.close();
				stmt.close();
			} catch (SQLException e) { 
				ErrorLoggerUtil.logError("UserService(getUserTypeId)","SQL ERROR: ", e);
				e.printStackTrace();
				//logger.error("Error: ",e);
			}
			finally{
				DBConnectionUtil.closeConnection(con);
				
			}
			return typeid;
			
			
		}
		
		public String getUserTypeById(int id){
			
			Connection con = DBConnectionUtil.getDBConnection();
			
			String sql="select type from user_types where id=?";
			String type="";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				if(rs.next()) {
					type=rs.getString("type");
				}	
				rs.close();
				stmt.close();
			} catch (SQLException e) { 
				ErrorLoggerUtil.logError("UserService(getUserTypeById)","SQL ERROR: ", e);
				e.printStackTrace();
				//logger.error("Error: ",e);
			}
			finally{
				DBConnectionUtil.closeConnection(con);
				
			}
			return type;
			
			
		}
			
}