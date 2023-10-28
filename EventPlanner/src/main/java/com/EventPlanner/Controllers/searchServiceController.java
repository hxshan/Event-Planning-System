package com.EventPlanner.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.EventPlanner.Models.Service;
import com.EventPlanner.Services.Services_Service;

/**
 * Servlet implementation class searchServiceController
 */
public class searchServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/Views/AllServices.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		HttpSession session=request.getSession();
		Services_Service Sservice=new Services_Service();
		
		if(search.length()>3) {
			List<Service> serviceList=Sservice.searchService(search);
			session.setAttribute("SList", serviceList);
		}else {
			List<Service> serviceList=Sservice.getAllServices();
			session.setAttribute("SList", serviceList);
		}
		
		
		response.sendRedirect("./searchServiceController");
	}

}
