package com.EventPlanner.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class PageRedirectController
 */
public class PageRedirectController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		
		if(page.equalsIgnoreCase("dashboard")){
			request.getRequestDispatcher("/WEB-INF/Views/Dashboard.jsp").forward(request, response);
		}else if(page.equalsIgnoreCase("org-profile")){
			request.getRequestDispatcher("/WEB-INF/Views/OrganiserEditProfile.jsp").forward(request, response);
		}
		
	}



}
