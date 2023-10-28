package com.EventPlanner.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mindrot.jbcrypt.BCrypt;

import com.EventPlanner.Models.Event;
import com.EventPlanner.Models.EventType;
import com.EventPlanner.Models.Service;
import com.EventPlanner.Models.ServiceType;
import com.EventPlanner.Models.User;
import com.EventPlanner.Models.Vendor;
import com.EventPlanner.Services.AddVendoService_Service;
import com.EventPlanner.Services.EventService;
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
				EventService eventservice=new EventService();
				String userType=userservice.getUserTypeById(user.getUserTypeId());
				HttpSession session=request.getSession();
				
				
				//pass relevant info depending on user type
				if( userType.compareToIgnoreCase("Organiser")==0 ){
					List<Event> Elist=eventservice.getUsersEvents(user.getId());
					List<EventType> etList=eventservice.getEventTypes();
					session.setAttribute("etList", etList);
					session.setAttribute("Elist", Elist);
					session.setAttribute("User",user);
					
				}
				else if(userType.compareToIgnoreCase("Vendor") ==0 ){
					
					
					VendorService vendorservice=new VendorService();
					Vendor vendor= vendorservice.getVendorDetails(email);
					List<ServiceType> stypeList =  vendorservice.GetServiceType();
					for(ServiceType s:stypeList){
						System.out.println(s.getServiceId());
					}
					List<Service> servicesList = vendorservice.getVendorsServices(vendor.getId());
					session.setAttribute("User",vendor);
					session.setAttribute("stypeList",stypeList);
					session.setAttribute("servicesList",servicesList);
				}
				
				//redirect to page
				RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/VendorDashboard.jsp");
				requestdispatcher.forward(request, response);
				
			}else {
				response.sendRedirect("static/Login.jsp?password=false");
			}
			
		}
		else {
			response.sendRedirect("static/Login.jsp?userExist=false");
		}
	}

}
