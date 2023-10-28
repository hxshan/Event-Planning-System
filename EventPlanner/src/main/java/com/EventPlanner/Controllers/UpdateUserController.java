package com.EventPlanner.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.EventPlanner.Models.User;
import com.EventPlanner.Services.UserService;

/**
 * Servlet implementation class UpdateUserController
 */
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int userid=Integer.parseInt(request.getParameter("userId").trim()); 
		
		UserService userservice = new UserService();		
		String Name=request.getParameter("name").trim();
		String Email=request.getParameter("email").trim();
		String PhoneNumber=request.getParameter("phoneNumber").trim();			  		
		
		userservice.updateUser(userid,Name,Email,PhoneNumber);
		User user=userservice.getUserDetailsById(userid);
		
		session.setAttribute("User",user);
		
		
		RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/Dashboard.jsp");
		requestdispatcher.forward(request, response);
		
	}

}
