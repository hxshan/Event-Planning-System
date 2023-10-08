package com.EventPlanner.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.EventPlanner.Models.User;
import com.EventPlanner.Services.UserService;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userservice=new UserService();
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		if(userservice.userExists(email)==true) {
			
			//checking password 
			String storedpwd=userservice.getUserPassword(email);
			boolean passwordMatch=BCrypt.checkpw(password, storedpwd);
			
			
			if(passwordMatch) {
				
				User user=userservice.getUserDetails(email);
				HttpSession session=request.getSession();
				session.setAttribute("User",user);
				
				RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/loggedIn.jsp");
				requestdispatcher.forward(request, response);
				
			}else {
				response.sendRedirect("Login.jsp?password=false");
			}
			
		}
		else {
			response.sendRedirect("Login.jsp?userExist=false");
		}
	}

}
