package com.EventPlanner.Services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import com.EventPlanner.Models.User;
import com.EventPlanner.Utils.*;

public class UserService {
	//private static final Logger logger=LogManager.getLogger(UserService.class);
		public void addUser(User user) {
			Connection con = DBConnectionUtil.getDBConnection();
			
			String sql="insert into users(id,email,PhoneNumber,name,password,user_type_id)values(NULL,?,?,?,?,?);";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,user.getEmail());	
				stmt.setString(2, user.getPhoneNumber());
				stmt.setString(3,user.getName());
				stmt.setString(4,user.getPassword());	
				stmt.setInt(5,user.getUserTypeId());
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
		
		public void updateUser(int userid,String Name,String Email,String PhoneNumber) {
			Connection con = DBConnectionUtil.getDBConnection();
			String sql="Update users set name=?,email=?,PhoneNumber=? where id=?;";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, Name);
				stmt.setString(2, Email);
				stmt.setString(3,PhoneNumber);
				stmt.setInt(4,userid);
				stmt.executeUpdate();
				stmt.close();
			} catch (SQLException e) {
				ErrorLoggerUtil.logError("UserService(updateUser)","SQL ERROR: ", e);
				
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
					user.setPhoneNumber(rs.getString("PhoneNumber"));
					user.setUserTypeId(rs.getInt("user_type_id"));
					user.setEncodedImage(rs.getString("image"));
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				ErrorLoggerUtil.logError("UserService(getuserDetails)","SQL ERROR: ", e);
				e.printStackTrace();
				
			}finally{
				DBConnectionUtil.closeConnection(con);
				
			}
			
			return user;
		}
		
		public User getUserDetailsById(int id) {
			Connection con = DBConnectionUtil.getDBConnection();		
			String sql="select * from users where id=?";
			User user=new User();
			try {
				PreparedStatement stmt=con.prepareStatement(sql);
				stmt.setInt(1,id);
				ResultSet rs=stmt.executeQuery();
				
				if(rs.next())
				{
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setEmail(rs.getString("email"));
					user.setPhoneNumber(rs.getString("PhoneNumber"));
					user.setUserTypeId(rs.getInt("user_type_id"));
					user.setEncodedImage(rs.getString("image"));
	                 
	                
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				ErrorLoggerUtil.logError("UserService(getuserDetailsByid)","SQL ERROR: ", e);
				e.printStackTrace();
				
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
				//e.printStackTrace();
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
				//e.printStackTrace();
				//logger.error("Error: ",e);
			}
			finally{
				DBConnectionUtil.closeConnection(con);
				
			}
			return type;
			
			
		}
			
		public void updateProfileImage(User user,int userid) {
			Connection con = DBConnectionUtil.getDBConnection();
			String sql="update users set image=? where id = ?;";
			try {
				PreparedStatement stmt = con.prepareStatement(sql);			
				stmt.setString(1, user.getEncodedImage());
				stmt.setInt(2, userid);
				stmt.executeUpdate();
				
			} catch (SQLException e) {
				ErrorLoggerUtil.logError("UserService(updateProfileImage)","Sql Error", e);
			}finally {
				DBConnectionUtil.closeConnection(con);
			}
			
		}
}