package com.EventPlanner.Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServiceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		
		String a1=request.getParameter("Servicename").trim();
		String a2=request.getParameter("discription").trim();
		String a3=request.getParameter("price").trim(); 
		
		if(a1.isBlank()&& a2.isBlank()&& a3.isBlank()) {
			response.setContentType("text/html");
			out.print("<script type=\"text/javascript\">");
			out.print("alert('Please Enter Service Details!')");
			out.print("</script>");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("");
            requestDispatcher.include(request, response);
		}else {
			 response.setContentType("text/html");  
             out.println("<script type=\"text/javascript\">");  
             out.println("alert('Success! ... Event Details Added To Database!');");  
             out.println("</script>");
		}

		
	}
	
}
