package com.EventPlanner.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import com.EventPlanner.Models.Service;
import com.EventPlanner.Services.AddVendoService_Service;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("");
        requestDispatcher.include(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		
		String Servicename=request.getParameter("Servicename").trim();
		String discription=request.getParameter("discription").trim();
		BigDecimal price= new BigDecimal(request.getParameter("price").trim()); 
		int VendorId=Integer.parseInt(request.getParameter("userId")) ;
		AddVendoService_Service Vs = new AddVendoService_Service();
		Service service = new Service(1,VendorId,Servicename,discription,price);
		
		Vs.AddService(service);
		
		response.sendRedirect("./ServiceController");
		

		
	}
	
}
