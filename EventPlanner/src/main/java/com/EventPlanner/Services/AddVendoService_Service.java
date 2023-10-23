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
		
		String sql= "insert into service (id,service_type_id,vendor_id,name,description,price) values (NULL,NULL,NULL,?,?,?); ";
			
		try{
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, service.getServiceName());
			pstmt.setString(2, service.getDescription());
			pstmt.setBigDecimal(3, service.getPrice());
			pstmt.executeUpdate();
			pstmt.close();
			
		
		
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DBConnectionUtil.closeConnection(con);
	}
}

}