package com.EventPlanner.Controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.EventPlanner.Models.User;
import com.EventPlanner.Models.Vendor;
import com.EventPlanner.Services.UserService;
import com.EventPlanner.Services.VendorService;


public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name").trim();
		String email=request.getParameter("email").trim();
		String pwd=request.getParameter("password").trim();
		String PhoneNumber=request.getParameter("contact").trim();
		String hashpwd=BCrypt.hashpw(pwd,BCrypt.gensalt());
		String userType=request.getParameter("userType").trim();
		
		
		if(userType.equalsIgnoreCase("User")) {
			UserService userservice = new UserService();
			User user = new User(userservice.getUserTypeId("Organiser"),name, email, PhoneNumber, hashpwd);
			userservice.addUser(user);			
			response.sendRedirect("./static/Login.jsp");
			
		}else if(userType.equalsIgnoreCase("Vendor")) {
			VendorService vendorservice = new VendorService();
			String description=request.getParameter("description").trim();
			String address=request.getParameter("address").trim();
			int TypeId=vendorservice.getUserTypeId("Vendor");
			
			
			Vendor vendor=new Vendor(TypeId,name,email,PhoneNumber,hashpwd,description,address);
			vendorservice.addVendor(vendor);
			response.sendRedirect("./static/Login.jsp");
		}
		
		
	}

}
