package com.EventPlanner.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.EventPlanner.Models.Event;
import com.EventPlanner.Models.Service;
import com.EventPlanner.Models.User;
import com.EventPlanner.Models.Vendor;
import com.EventPlanner.Services.EventService;
import com.EventPlanner.Services.Services_Service;
import com.EventPlanner.Services.VendorService;
import com.oracle.wls.shaded.org.apache.xalan.templates.ElemAttributeSet;


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
			int serviceId= Integer.parseInt( request.getParameter("serviceId"));
					
			Service currentService= S_service.getServiceById(serviceId);
			VendorService vendorservice=new VendorService();			
			Vendor vendor = vendorservice.getVendorDetailsById(currentService.getVendorId());
			
			session.setAttribute("currentService",currentService);	
			session.setAttribute("currentService_vendor",vendor);	
			
			request.getRequestDispatcher("/WEB-INF/Views/ServiceDetails.jsp").forward(request, response);
			
		}
		else if(page.equalsIgnoreCase("AllEvents")) {
			session.setAttribute("activePage","AllEvents");
			EventService eventservice=new EventService();
			
			int userid=Integer.parseInt(request.getParameter("userid"));
			List<Event> UpcomingEvents=eventservice.getUsersEventsForDate(userid,LocalDate.now(),'U');
			List<Event> PastEvents=eventservice.getUsersEventsForDate(userid,LocalDate.now(),'P');
	
			List<Event> Elist=eventservice.getUsersEvents(userid);
			session.setAttribute("Elist", Elist);
			session.setAttribute("UpcomingEvents", UpcomingEvents);
			session.setAttribute("PastEvents", PastEvents); 
			
			request.getRequestDispatcher("/WEB-INF/Views/AllEvents.jsp").forward(request, response);
		}
		else if(page.equalsIgnoreCase("AllVendors")) {
			session.setAttribute("activePage","AllVendors");
			VendorService vendorservice=new VendorService();
			List<Vendor> Vlist =vendorservice.getAllVendors();
			session.setAttribute("Vlist", Vlist);
			request.getRequestDispatcher("/WEB-INF/Views/AllVendors.jsp").forward(request, response);
		}
		
		
		
		else if (page.equalsIgnoreCase("AddService")) {
			request.getRequestDispatcher("/WEB-INF/Views/AddService.jsp").forward(request, response);
		}
		else if (page.equalsIgnoreCase("VendorDashboard")) {
			request.getRequestDispatcher("/WEB-INF/Views/VendorDashboard.jsp").forward(request, response);
		}
		else if (page.equalsIgnoreCase("AllVendorServices")) {
			request.getRequestDispatcher("/WEB-INF/Views/AllVendorServices.jsp").forward(request, response);
		}
		
		else if (page.equalsIgnoreCase("VendorAllServices")) {
			int vendorId= Integer.parseInt(request.getParameter("vendorid"))   ;
			
			
			VendorService vService = new VendorService();
			List<Service> SList = vService.getVendorsServices(vendorId);
			
			System.out.println(vendorId);
			
			session.setAttribute("SVList", SList);
			request.getRequestDispatcher("/WEB-INF/Views/AllVendorServices.jsp").forward(request, response);
		}
	}



}
