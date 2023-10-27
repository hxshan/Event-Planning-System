package com.EventPlanner.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.EventPlanner.Models.Event;
import com.EventPlanner.Models.Service;
import com.EventPlanner.Models.User;
import com.EventPlanner.Services.EventService;
import com.EventPlanner.Services.Services_Service;

/**
 * Servlet implementation class PageRedirectController
 */
public class PageRedirectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		HttpSession session=request.getSession();
		
		if(page.equalsIgnoreCase("dashboard")){
			session.setAttribute("activePage","dashboard");
			request.getRequestDispatcher("/WEB-INF/Views/Dashboard.jsp").forward(request, response);
		}
		
		else if(page.equalsIgnoreCase("org-profile")){
			request.getRequestDispatcher("/WEB-INF/Views/OrganiserEditProfile.jsp").forward(request, response);
		}
		else if(page.equalsIgnoreCase("services")){
			session.setAttribute("activePage","none");
			Services_Service S_service=new Services_Service();
			
			
			List<Service> serviceList=S_service.getAllServices();
			session.setAttribute("SList", serviceList);
			request.getRequestDispatcher("/WEB-INF/Views/AllServices.jsp").forward(request, response);
			
		}
		else if(page.equalsIgnoreCase("serviceDetail")) {
			session.setAttribute("activePage","none");
			Services_Service S_service=new Services_Service();
			int serviceId= Integer.parseInt( request.getParameter("serviceDetail"));
			
			
			Service currentService= S_service.getServiceById(serviceId);
			session.setAttribute("currentService",currentService);	
			request.getRequestDispatcher("/WEB-INF/Views/AllServices.jsp").forward(request, response);
			
		}
		else if(page.equalsIgnoreCase("AllEvents")) {
			session.setAttribute("activePage","AllEvents");
			EventService eventservice=new EventService();
			int userid=Integer.parseInt(request.getParameter("userid"));
			
			List<Event> Elist=eventservice.getUsersEvents(userid);
			session.setAttribute("Elist", Elist);
			
			request.getRequestDispatcher("/WEB-INF/Views/AllEvents.jsp").forward(request, response);
		}
		
		
		
	}



}
