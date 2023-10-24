package com.EventPlanner.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.EventPlanner.Models.Service;

import com.EventPlanner.Utils.DBConnectionUtil;

public class AddVendoService_Service  {
		
	public AddVendoService_Service() {}
	
	public void AddService(Service service) {
		Connection con = DBConnectionUtil.getDBConnection();
		
		String sql= "insert into service (id,service_type_id,vendor_id,name,description,price) values (NULL,1,?,?,?,?); ";
			
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, service.getVendorId());
			pstmt.setString(2, service.getServiceName());
			pstmt.setString(3, service.getDescription());
			pstmt.setBigDecimal(4, service.getPrice());
			pstmt.executeUpdate();
			pstmt.close();
			
		
		
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DBConnectionUtil.closeConnection(con);
	}
}

}