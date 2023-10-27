package com.EventPlanner.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;
import com.EventPlanner.Models.Event;
import com.EventPlanner.Models.EventType;
import com.EventPlanner.Models.User;
import com.EventPlanner.Models.Vendor;
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
					session.setAttribute("activePage","dashboard");
					
					RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Dashboard.jsp");
					requestdispatcher.forward(request, response);
					
				}
				else if(userType.compareToIgnoreCase("Vendor") ==0 ){
					
					VendorService vendorservice=new VendorService();
					Vendor vendor= vendorservice.getVendorDetails(email);		
					session.setAttribute("User",vendor);
					
					
					RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/testVendor.jsp");
					requestdispatcher.forward(request, response);
				}
				
				//redirect to page

				
			}else {
				response.sendRedirect("static/Login.jsp?password=false");
			}
			
		}
		else {
			response.sendRedirect("static/Login.jsp?userExist=false");
		}
	}

}
