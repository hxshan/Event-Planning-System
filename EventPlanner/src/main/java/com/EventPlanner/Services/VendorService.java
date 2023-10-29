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

				vendor.setEncodedImage(rs.getString("image"));

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

				vendor.setEncodedImage(rs.getString("image"));

				
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
		String sql = "select * from service where vendor_id=?";
		ResultSet rSet = null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vendorid);
			rSet = pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Service> SList = new ArrayList<Service>();
		
		try {
			
				while(rSet.next()) {
					int Id = rSet.getInt("id");
					int ServiceTypeId = rSet.getInt("service_type_id");
					int VendorId = rSet.getInt("vendor_id");
					String ServiceName = rSet.getString("name");
					String Description = rSet.getString("description");
					BigDecimal Price = rSet.getBigDecimal("price");
					
					
					
					SList.add(new Service(Id,ServiceTypeId,VendorId,ServiceName,Description,Price));
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.closeConnection(con);
		}for (Service service : SList) {
		System.out.println(service.getDescription());	
			
		}
		
		return SList;
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

				String encodedImage=rs.getString("image");

				
				Vlist.add(new Vendor(Id,UserTypeId,Name,Email, PhoneNumber,password,encodedImage,Description,Address));
			}
			
		} catch (SQLException e) {
			ErrorLoggerUtil.logError("VendorService(getAllVendors)","SQL ERROR: ", e);
		}finally{
			DBConnectionUtil.closeConnection(con);
			
		}
		return Vlist;
		
		
		
	}

	
	public String getServiceTypeByID(int typeid) {
		Connection con = DBConnectionUtil.getDBConnection();
		String sql = "Select type from servicetype where id = ?";
		ResultSet rs = null;
		String type = "";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, typeid);
			rs = pstmt.executeQuery();
			if ( rs.next()) {
					type = rs.getString("type");
			}
			
			pstmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnectionUtil.closeConnection(con);
		}
		
		return type;
	}
	
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
			e.printStackTrace();
		}finally {
			DBConnectionUtil.closeConnection(con);
		}
	}


public Vendor getLatestVendor() {
	Connection con = DBConnectionUtil.getDBConnection();		
	String sql="select * from users where user_type_id =(select id from user_types where type ='Vendor') order by id desc limit 1;";
	PreparedStatement stmt;
	Vendor vendor=new Vendor();
	try {
		stmt = con.prepareStatement(sql);
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
			vendor.setEncodedImage(rs.getString("image"));
			
		}
		rs.close();
		stmt.close();
	} catch (SQLException e) {
		
		ErrorLoggerUtil.logError("VendorService(getAllVendors)","SQL ERROR: ", e);
	}finally{
		DBConnectionUtil.closeConnection(con);
		
	}
	return vendor;
	
}

}


