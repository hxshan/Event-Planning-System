package com.EventPlanner.Services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;


import com.EventPlanner.Utils.DBConnectionUtil;
import com.EventPlanner.Utils.ErrorLoggerUtil;

public class UpdateVenderServiceDetails {
	public void UpdateVendorServices(int serviceId, int vendorId, String servicename, String description,
			BigDecimal price) {
		Connection con = DBConnectionUtil.getDBConnection();
		
		String sql="update service set name=?,description=?,price=? where id=? and vendor_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, servicename);
			pstmt.setString(2, description);
			pstmt.setBigDecimal(3, price);
			pstmt.setInt(4, serviceId);
			pstmt.setInt(5, vendorId);
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (Exception e) {
			ErrorLoggerUtil.logError("UpdateVenderServiceDetails(UpdateVendorServices)","SQL ERROR: ", e);
		}finally {
			DBConnectionUtil.closeConnection(con);
		}
	}

//	public void UpdateVendorServices() {
		// TODO Auto-generated method stub
		
	}

