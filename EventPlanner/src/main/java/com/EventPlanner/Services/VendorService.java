package com.EventPlanner.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.EventPlanner.Models.User;
import com.EventPlanner.Models.Vendor;
import com.EventPlanner.Utils.DBConnectionUtil;
import com.EventPlanner.Utils.ErrorLoggerUtil;

public class VendorService extends UserService{
	
	public VendorService() {}
	
	
	public void addVendor(Vendor vendor) {
		Connection con = DBConnectionUtil.getDBConnection();
		
		String sql="insert into users(id,email,name,password,user_type_id)values(NULL,?,?,?,?,?,?,?);";
		
		
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,vendor.getEmail());	
			stmt.setString(2,vendor.getName());
			stmt.setString(3,vendor.getPassword());	
			stmt.setInt(4,vendor.getUserTypeId());
			stmt.setString(5,vendor.getDescription());
			stmt.setString(6,vendor.getAddress());
			stmt.setInt(7,vendor.getserviceTypeId());
			
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			//logger.error("Error: ",e);
			ErrorLoggerUtil.logError("UserService","SQL ERROR: ", e);
			
		}finally {
			DBConnectionUtil.closeConnection(con);
		}
			
	}
	
	
	
	public Vendor getVendorDetails(String email) {
		Connection con = DBConnectionUtil.getDBConnection();		
		String sql="select * from users where email=?";
		Vendor vendor=new Vendor();
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,email);
			ResultSet rs=stmt.executeQuery();
			
			if(rs.next())
			{
				vendor.setId(rs.getInt("id"));
				vendor.setName(rs.getString("name"));
				vendor.setEmail(rs.getString("email"));
				vendor.setUserTypeId(rs.getInt("user_type_id"));
				vendor.setDescription(rs.getString("description"));
				vendor.setAddress(rs.getString("address"));
				vendor.setserviceTypeId(rs.getInt("service_type_id"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			ErrorLoggerUtil.logError("UserService","SQL ERROR: ", e);
			e.printStackTrace();
			//logger.error("Error: ",e);
		}finally{
			DBConnectionUtil.closeConnection(con);
			
		}
		
		return vendor;
	}
}
