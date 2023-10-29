package com.EventPlanner.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;



import com.EventPlanner.Models.Service;
import com.EventPlanner.Services.AddVendoService_Service;
import com.EventPlanner.Services.VendorService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/Views/VendorDashboard.jsp");
        requestDispatcher.include(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		String triggerType = request.getParameter("triggerType");
		AddVendoService_Service addvendorService = new AddVendoService_Service();
		HttpSession session=request.getSession();
		
		//Add service 
		
		if(triggerType.equalsIgnoreCase("AddService")) {

		
		int VendorId=Integer.parseInt(request.getParameter("userId")) ;
		int ServiceTypeId=Integer.parseInt(request.getParameter("TypeId")) ;
		
		String Servicename=request.getParameter("Servicename");
		String description=request.getParameter("description");
		BigDecimal price= new BigDecimal(request.getParameter("price")); 
		
		Service service = new Service(0,VendorId,ServiceTypeId , Servicename,description,price);
		
		
		addvendorService.AddService(service);
		
		VendorService vendorService = new VendorService();
		List<Service> ServiceList = vendorService.getVendorsServices(VendorId);
		session.setAttribute("ServiceList", ServiceList);
		
		response.sendRedirect("./ServiceController");
		
		
		
		}
		
		//Update Service 
		
		else if(triggerType.equalsIgnoreCase("UpdateService")){
			int ServiceId=Integer.parseInt(request.getParameter("ServiceId")) ;
			
			Service service =  addvendorService.getServiceDetails(ServiceId);
			int VendorId=Integer.parseInt(request.getParameter("VendorId")) ;
			
		
		
			session.setAttribute("currentService", service);
			
			
			RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/EditVendorServicesDetails.jsp");
			requestdispatcher.forward(request, response);
		}
		
	
	
	
		//Delete Service 
		
		else if(triggerType.equalsIgnoreCase("DeleteService")) {
			
		int ServiceId=Integer.parseInt(request.getParameter("serviceId")) ;	
		int VendorId=Integer.parseInt(request.getParameter("vendorId")) ;
		
		
		addvendorService.deleteService(ServiceId);
		VendorService vendorService = new VendorService();
		
	
		List<Service> ServiceList = vendorService.getVendorsServices(VendorId);
		for(Service S:ServiceList) {
			S.setServiceType(vendorService.getServiceTypeByID(S.getServiceTypeId()));
		}
		
		
		
		session.setAttribute("ServiceList", ServiceList);
		response.sendRedirect("./ServiceController");
		
	//	RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/AllVendorServices.jsp");
	//	requestdispatcher.forward(request, response);
		
	}
}
}
