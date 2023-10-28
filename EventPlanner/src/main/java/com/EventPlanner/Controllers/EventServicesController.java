package com.EventPlanner.Controllers;

import jakarta.servlet.RequestDispatcher;
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
import com.EventPlanner.Services.EventService;

/**
 * Servlet implementation class EventServicesController
 */
public class EventServicesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/EventDetails.jsp");
		requestdispatcher.forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session=request.getSession();
		 int servId=Integer.parseInt(request.getParameter("serviceId")) ;
		 int eventId=Integer.parseInt(request.getParameter("eventId")) ;
		 EventService eventservice=new EventService();
		 String triggerType =request.getParameter("triggerType");
       
		 if(triggerType.equalsIgnoreCase("addService")) {
			
			 eventservice.addServiceToEvent(eventId,servId,"TBD"); 	   
			 List<Service> EventServicesList = eventservice.getEventsItems(eventId);
			 session.setAttribute("EventServicesList", EventServicesList);	   
			 response.sendRedirect("./EventServicesController");
			 
       }else if(triggerType.equalsIgnoreCase("deleteService")) {
    	   eventservice.deleteEventService(eventId, servId);
    	   List<Service> EventServicesList = eventservice.getEventsItems(eventId);
			 session.setAttribute("EventServicesList", EventServicesList);	   
			 response.sendRedirect("./EventServicesController");
    	   
       }
		 
		
	}

}
