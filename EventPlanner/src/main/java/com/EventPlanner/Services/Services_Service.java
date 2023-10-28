package com.EventPlanner.Services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.EventPlanner.Models.Service;
import com.EventPlanner.Utils.DBConnectionUtil;
import com.EventPlanner.Utils.ErrorLoggerUtil;
public class Services_Service {
	
	public List<Service> getAllServices(){
		Connection con =DBConnectionUtil.getDBConnection();
		List<Service> serviceList=new ArrayList<Service>();
		String sql="select * from service;";
		PreparedStatement stmt;
		ResultSet rs=null;
		try {
			stmt = con.prepareStatement(sql);
			rs=stmt.executeQuery();

			while(rs.next()) {
					int id=rs.getInt("id");
					int serviceTypeId=rs.getInt("service_type_id");
					int vendorId=rs.getInt("vendor_id");
					String name=rs.getString("name");
					String description=rs.getString("description");
					BigDecimal price=rs.getBigDecimal("price");
					serviceList.add(new Service(id,serviceTypeId,vendorId,name,description,price));		
			}
			
			
		} catch (SQLException e) {
			ErrorLoggerUtil.logError("Services_Service(getAllServices)","SQL ERROR: ", e);
		
		}finally {
			DBConnectionUtil.closeConnection(con);
		}
		
		return serviceList;
			
	}
	
	public Service getServiceById(int id) {
		Connection con =DBConnectionUtil.getDBConnection();
		String sql="select * from service where id=?;";
		Service service=new Service();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs= stmt.executeQuery();
			if(rs.next()) {
				service.setId(rs.getInt("id"));
				service.setServiceTypeId(rs.getInt("service_type_id"));
				service.setVendorId(rs.getInt("vendor_id"));
				service.setServiceName(rs.getString("name"));
				service.setDescription(rs.getString("description"));
				service.setPrice(rs.getBigDecimal("price"));
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			ErrorLoggerUtil.logError("Services_Service(getServiceById)","SQL ERROR: ", e);
		}finally {
			DBConnectionUtil.closeConnection(con);
		}
		
		return service;
	}
	public List<Service> searchService(String search) {
		Connection con =DBConnectionUtil.getDBConnection();
		List<Service> serviceList=new ArrayList<Service>();
		String sql="select * from service where name like ? ;";
		PreparedStatement stmt;
		ResultSet rs=null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + search + "%");
			rs=stmt.executeQuery();
			while(rs.next()) {
					int id=rs.getInt("id");
					int serviceTypeId=rs.getInt("service_type_id");
					int vendorId=rs.getInt("vendor_id");
					String name=rs.getString("name");
					String description=rs.getString("description");
					BigDecimal price=rs.getBigDecimal("price");
					serviceList.add(new Service(id,serviceTypeId,vendorId,name,description,price));		
			}
		} catch (SQLException e) {
			ErrorLoggerUtil.logError("Services_Service(searchService)","SQL ERROR: ", e);
		}finally {
			DBConnectionUtil.closeConnection(con);
		}
		
		return serviceList;
	}
	
	
}
