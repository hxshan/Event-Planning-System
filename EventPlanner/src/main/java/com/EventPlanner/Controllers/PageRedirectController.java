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

import com.EventPlanner.Models.Service;
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
			request.getRequestDispatcher("/WEB-INF/Views/Dashboard.jsp").forward(request, response);
		}else if(page.equalsIgnoreCase("org-profile")){
			request.getRequestDispatcher("/WEB-INF/Views/OrganiserEditProfile.jsp").forward(request, response);
		}
		
		else if(page.equalsIgnoreCase("services")){
			
			Services_Service S_service=new Services_Service();
			List<Service> serviceList=S_service.getAllServices();
			
			for(Service s:serviceList) {
				System.out.println(s.getServiceName());
			}
				
			
			session.setAttribute("SList", serviceList);
		
			request.getRequestDispatcher("/WEB-INF/Views/AllServices.jsp").forward(request, response);
		}
		
	}



}
