package com.EventPlanner.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import java.time.LocalDate;
import java.util.List;

import com.EventPlanner.Models.Event;
import com.EventPlanner.Models.EventType;
import com.EventPlanner.Services.EventService;

public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Dashboard.jsp");
		requestdispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String triggerType=request.getParameter("triggerType");//Which type of action is done (insert,update or a delete)
		EventService eventservice=new EventService();
		HttpSession session=request.getSession();
		//List<EventType> et = eventservice.getEventTypes();
	
		if(triggerType.equalsIgnoreCase("AddEvent")) {
			
			String eventName=request.getParameter("EventName").trim();
			int typeId = Integer.parseInt(request.getParameter("eventType"));
			int userid=Integer.parseInt(request.getParameter("userId"));
			
			String startdateString =request.getParameter("startDate");
			String enddateString =request.getParameter("endDate");
			LocalDate startdate=LocalDate.parse(startdateString);
			LocalDate enddate=LocalDate.parse(enddateString);

			
			Event event=new Event(eventName,typeId,startdate,enddate,userid);
		
			eventservice.addEvent(event);
			
			List<Event> Elist=eventservice.getUsersEvents(userid);
			session.setAttribute("Elist", Elist);

			/*RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Dashboard.jsp");
			requestdispatcher.forward(request, response);*/
			response.sendRedirect("./EventController");
			
		}else if(triggerType.equalsIgnoreCase("EditEvent")) {
			
			
			
		}else if(triggerType.equalsIgnoreCase("DeleteEvent")) {
			
			int eventId =Integer.parseInt( request.getParameter("eventId"));
			int userid=Integer.parseInt(request.getParameter("userId"));
			eventservice.deleteEvent(eventId);
			
			List<Event> Elist=eventservice.getUsersEvents(userid);
			
			session.setAttribute("Elist", Elist);
			response.sendRedirect("./EventController");
			
			/*RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Dashboard.jsp");
			requestdispatcher.forward(request, response);*/
		}
		
		
	}

}