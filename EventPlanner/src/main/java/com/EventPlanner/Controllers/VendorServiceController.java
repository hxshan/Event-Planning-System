package com.EventPlanner.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.EventPlanner.Models.Service;
import com.EventPlanner.Services.AddVendoService_Service;
import com.EventPlanner.Services.VendorService;

/**
 * Servlet implementation class VendorServiceController
 */
public class VendorServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/AllVendorServices.jsp");
		requestdispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();
		int ServiceId = Integer.parseInt(request.getParameter("serviceId"));
		int VendorId = Integer.parseInt(request.getParameter("vendorId"));	
		VendorService vendorservice = new VendorService();
		
		AddVendoService_Service Avservice =new AddVendoService_Service();
		
		Avservice.deleteService(ServiceId);
		List<Service> SList = vendorservice.getVendorsServices(VendorId);
		
		System.out.println(VendorId);
		
		session.setAttribute("SVList", SList);
		
		response.sendRedirect("./VendorServiceController");
		
	}

}
