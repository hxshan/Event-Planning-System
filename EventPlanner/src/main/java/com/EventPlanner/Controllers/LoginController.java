package com.EventPlanner.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.EventPlanner.Models.User;
import com.EventPlanner.Models.Vendor;
import com.EventPlanner.Services.UserService;
import com.EventPlanner.Services.VendorService;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userservice=new UserService();
		String password = request.getParameter("password").trim();
		String email = request.getParameter("email").trim();
		
		if(userservice.userExists(email)==true) {
			
			//checking password 
			String storedpwd=userservice.getUserPassword(email);
			boolean passwordMatch=BCrypt.checkpw(password, storedpwd);
			
			
			if(passwordMatch) {
				
				User user=userservice.getUserDetails(email);
				String userType=userservice.getUserTypeById(user.getUserTypeId());
				
				//pass relevant info depending on user type
				if( userType == "Organiser"){
					HttpSession session=request.getSession();
					session.setAttribute("User",user);
					
				}
				else if(userType == "Vendor"){
					VendorService vendorservice=new VendorService();
					Vendor vendor= vendorservice.getVendorDetails(email);
					HttpSession session=request.getSession();
					session.setAttribute("User",vendor);
				}
				
				//redirect to page
				RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Dashboard.jsp");
				requestdispatcher.forward(request, response);
				
			}else {
				response.sendRedirect("Login.jsp?password=false");
			}
			
		}
		else {
			response.sendRedirect("Login.jsp?userExist=false");
		}
	}

}
