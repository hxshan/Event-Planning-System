package com.EventPlanner.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EventPlanner.Models.User;
import com.EventPlanner.Models.Vendor;
import com.EventPlanner.Utils.DBConnectionUtil;
import com.EventPlanner.Utils.ErrorLoggerUtil;

public class VendorService extends UserService{
	
	public VendorService() {}
	
	
	public void addVendor(Vendor vendor) {
		Connection con = DBConnectionUtil.getDBConnection();
    
		String sql="insert into users(id,email,PhoneNumber,name,password,user_type_id,description,address)values(NULL,?,?,?,?,?,?,?);";
		
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,vendor.getEmail());
			stmt.setString(2,vendor.getPhoneNumber());
			stmt.setString(3,vendor.getName());
			stmt.setString(4,vendor.getPassword());	
			stmt.setInt(5,vendor.getUserTypeId());
			stmt.setString(6,vendor.getDescription());
			stmt.setString(7,vendor.getAddress());
			
			
			stmt.executeUpdate();
			stmt.close();
			
		} catch (SQLException e) {
			ErrorLoggerUtil.logError("VendorService(addVendor)","SQL ERROR: ", e);
			
		}finally {
			DBConnectionUtil.closeConnection(con);
			
		}
			
	}
	
	public Vendor getVendorDetailsById(int vendorId) {
		Connection con = DBConnectionUtil.getDBConnection();		
		String sql="select * from users where id=?";
		Vendor vendor=new Vendor();
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setInt(1,vendorId);
			ResultSet rs=stmt.executeQuery();
			
			if(rs.next())
			{
				vendor.setId(rs.getInt("id"));
				vendor.setName(rs.getString("name"));
				vendor.setEmail(rs.getString("email"));
				vendor.setUserTypeId(rs.getInt("user_type_id"));
				vendor.setDescription(rs.getString("description"));
				vendor.setAddress(rs.getString("address"));
				vendor.setEncodedImage(rs.getString("encodedImage"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			ErrorLoggerUtil.logError("VendorService(getVendorDetailsById)","SQL ERROR: ", e);
			e.printStackTrace();
			//logger.error("Error: ",e);
		}finally{
			DBConnectionUtil.closeConnection(con);
			
		}
		
		return vendor;
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
				vendor.setPhoneNumber(rs.getString("PhoneNumber"));
				vendor.setUserTypeId(rs.getInt("user_type_id"));
				vendor.setDescription(rs.getString("description"));
				vendor.setAddress(rs.getString("address"));
				vendor.setEncodedImage(rs.getString("encodedImage"));
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			ErrorLoggerUtil.logError("VendorService(getVendorDetails)","SQL ERROR: ", e);
			e.printStackTrace();
			//logger.error("Error: ",e);
		}finally{
			DBConnectionUtil.closeConnection(con);
			
		}
		
		return vendor;
	}
	
	public List<Vendor> getAllVendors(){
		Connection con = DBConnectionUtil.getDBConnection();		
		String sql="select * from users where user_type_id =(select id from user_types where type ='Vendor');";
		List<Vendor> Vlist=new ArrayList<Vendor>();
		
		try {
			PreparedStatement stmt=con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				int Id=(rs.getInt("id"));
				String Name=(rs.getString("name"));
				String password=(rs.getString("password"));
				String Email=(rs.getString("email"));
				String PhoneNumber =rs.getString("PhoneNumber");
				int UserTypeId=(rs.getInt("user_type_id"));
				String Description=(rs.getString("description"));
				String Address=(rs.getString("address"));
				String encodedImage=rs.getString("encodedImage");
				
				Vlist.add(new Vendor(Id,UserTypeId,Name,Email, PhoneNumber,password,encodedImage,Description,Address));
			}
			
		} catch (SQLException e) {
			ErrorLoggerUtil.logError("VendorService(getAllVendors)","SQL ERROR: ", e);
		}finally{
			DBConnectionUtil.closeConnection(con);
			
		}
		return Vlist;
		
		
		
	}
	
	
	
}
