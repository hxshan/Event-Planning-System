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
			e.printStackTrace();
		}finally {
			DBConnectionUtil.closeConnection(con);
		}
		
		return serviceList;
			
	}
	
	
	
}
