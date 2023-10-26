package com.EventPlanner.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import org.apache.catalina.tribes.ChannelSender;

import com.EventPlanner.Models.Service;
import com.EventPlanner.Services.AddVendoService_Service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/Views/Vendor.jsp");
        requestDispatcher.include(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			/*response.setContentType("text/html");
			PrintWriter out = response.getWriter();*/
		String triggerType = request.getParameter("triggerType");
		AddVendoService_Service addvendorService = new AddVendoService_Service();
		HttpSession session=request.getSession();
		
		
		
		if(triggerType.equalsIgnoreCase("AddService")) {
		
		int VendorId=Integer.parseInt(request.getParameter("userId")) ;
		int TypeId=Integer.parseInt(request.getParameter("TypeId")) ;
		
		String Servicename=request.getParameter("Servicename").trim();
		String discription=request.getParameter("discription").trim();
		BigDecimal price= new BigDecimal(request.getParameter("price").trim()); 
		
		Service service = new Service(1,VendorId,TypeId,Servicename,discription,price);
		
		addvendorService.AddService(service);
		
		List<Service> ServiceList = addvendorService.getVendorsServices(VendorId);
		session.setAttribute("ServiceList", ServiceList);
		
		response.sendRedirect("./ServiceController");
		
		}
		
		else if(triggerType.equalsIgnoreCase("EditService")){
			int VendorId=Integer.parseInt(request.getParameter("userId")) ;
			int ServiceTypeId=Integer.parseInt(request.getParameter("ServiceTypeId")) ;
			
			Service service =  addvendorService.getServiceDetails(ServiceTypeId);
			session.setAttribute("currentService", service);
			
			RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/VendorServicesDetails.jsp");
			requestdispatcher.forward(request, response);
		}
		
	
	
	else if(triggerType.equalsIgnoreCase("DeleteService")) {
		int VendorId=Integer.parseInt(request.getParameter("userId")) ;
		int ServiceTypeId=Integer.parseInt(request.getParameter("ServiceTypeId")) ;
		
		addvendorService.deleteService(VendorId);
		
		List<Service> ServiceList = addvendorService.getVendorsServices(VendorId);
		
		session.setAttribute("ServiceList", ServiceList);
		response.sendRedirect("./ServiceController");
		
	}
}
}
