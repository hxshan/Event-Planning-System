package com.EventPlanner.Services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.net.jsse.PEMFile;

import com.EventPlanner.Models.Event;
import com.EventPlanner.Models.Service;
import com.EventPlanner.Models.ServiceType;
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
	
	public List<ServiceType>  GetServiceType() {
		Connection con = DBConnectionUtil.getDBConnection();	
		String sql="select * from servicetype";
		List<ServiceType> StypeList = new ArrayList<ServiceType>();
		
		PreparedStatement stmt;
		try {
			
			stmt = con.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery();
			
			
			
			while (rs.next()) {
			
				 int id =  ( rs.getInt("id"));
				 String Type = (rs.getString("type"));
				String Description =(rs.getString("description"));
				
				
				StypeList.add(new ServiceType(id,Type,Description));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DBConnectionUtil.closeConnection(con);
		}
		
		
		return StypeList;
	}
	
	public List<Service> getVendorsServices(int vendorid){
		Connection con = DBConnectionUtil.getDBConnection();
		String sql = "select * from service where vendor_id = ?";
		ResultSet rSet = null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vendorid);
			rSet = pstmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Service> SList = new ArrayList<Service>();
		
		try {
			if (rSet != null) {
				while(rSet.next()) {
					int Id = rSet.getInt("id");
					int ServiceTypeId = rSet.getInt("service_type_id");
					int VendorId = rSet.getInt("vendor_id");
					String ServiceName = rSet.getString("name");
					String Description = rSet.getString("description");
					BigDecimal Price = rSet.getBigDecimal("price");
					
					SList.add(new Service(Id,ServiceTypeId,VendorId,ServiceName,Description,Price));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.closeConnection(con);
		}
		
		return SList;
	}
}
