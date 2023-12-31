package com.EventPlanner.Services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.EventPlanner.Models.Service;


import com.EventPlanner.Utils.DBConnectionUtil;
import com.EventPlanner.Utils.ErrorLoggerUtil;


public class AddVendoService_Service  {
		
	public AddVendoService_Service() {}
	
	public void AddService(Service service) {
		Connection con = DBConnectionUtil.getDBConnection();
		
		String sql= "insert into service(service_type_id,vendor_id,name,description,price) values (?,?,?,?,?); ";
			
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,service.getServiceTypeId());			pstmt.setInt(2, service.getVendorId());
			pstmt.setString(3, service.getServiceName());
			pstmt.setString(4, service.getDescription());
			pstmt.setBigDecimal(5, service.getPrice());
			pstmt.executeUpdate();
			pstmt.close();
			
		
		
	}catch (SQLException e) {
		ErrorLoggerUtil.logError("AddVendoService_Service(AddService)","SQL ERROR: ", e);
	}finally {
		DBConnectionUtil.closeConnection(con);
	}
}
	
	
	
	
	
	public Service getServiceDetails(int serviceID) {
		Connection con = DBConnectionUtil.getDBConnection();
		String sql = "select * from service where id=?";
		Service service = new Service();
		ResultSet rSet = null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, serviceID);
			rSet = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(rSet.next()) {
				service.setId(rSet.getInt("id"));
				service.setServiceTypeId(rSet.getInt("service_type_id"));
				service.setVendorId(rSet.getInt("vendor_id"));
				service.setServiceName(rSet.getString("name"));
				service.setDescription(rSet.getString("description"));
				service.setPrice(rSet.getBigDecimal("price"));
				service.setImage(rSet.getString("image"));
			}
		} catch (Exception e) {
			ErrorLoggerUtil.logError("AddVendoService_Service(getServiceDetails)","SQL ERROR: ", e);
		}
		return service;
		
	}

	public void deleteService(int serviceId) {
		Connection con = DBConnectionUtil.getDBConnection();
		String sql = "delete from service where id=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, serviceId);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			ErrorLoggerUtil.logError("AddVendoService_Service(deleteService)","SQL ERROR: ", e);
		}finally {
			DBConnectionUtil.closeConnection(con);
		}
		
	}
	

}