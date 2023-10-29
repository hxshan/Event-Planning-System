package com.EventPlanner.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.EventPlanner.Models.Service;
import com.EventPlanner.Services.UpdateVenderServiceDetails;
import com.EventPlanner.Services.VendorService;

/**
 * Servlet implementation class EditVendorServiceDetails
 */
public class EditVendorServiceDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditVendorServiceDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/AllVendorServices.jsp");
		requestdispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int ServiceId = Integer.parseInt(request.getParameter("Id"));
		int VendorId = Integer.parseInt(request.getParameter("userId"));	
		VendorService vendorservice = new VendorService();
		
		
		
		String Servicename=request.getParameter("Servicename");
		String description=request.getParameter("description");
		BigDecimal price= new BigDecimal(request.getParameter("price"));
		
		vendorservice.UpdateVendorServices(ServiceId,VendorId,Servicename,description,price);
		List<Service> SList = vendorservice.getVendorsServices(VendorId);
		
		System.out.println(VendorId);
		
		session.setAttribute("SVList", SList);
		
		response.sendRedirect("./EditVendorServiceDetails");
		
	}

}
