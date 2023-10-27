package com.EventPlanner.Controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.UUID;

import com.EventPlanner.Models.User;
import com.EventPlanner.Services.UserService;


@MultipartConfig
public class EditProfileImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher requestdispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Views/OrganiserEditProfile.jsp");
		requestdispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userservice=new UserService();
		int userId=Integer.parseInt(request.getParameter("userId"));
		Part image=request.getPart("profile-pic-input");
		User user=userservice.getUserDetailsById(userId);
		 
		/*
		String imageName=image.getSubmittedFileName();
		
		 * String uuid = UUID.randomUUID().toString(); String uniqueFileName
		 * =uuid+imageName; String uploadDirectory
		 * ="C:/Users/LENOVO/git/Event-Planning-System/EventPlanner/src/main/webapp/uploads/"
		 * +uniqueFileName; System.out.println(uploadDirectory);
		 FileOutputStream output = new FileOutputStream(uploadDirectory);
		 */
		
		 //save file to local folder
		
		 
		 InputStream input = image.getInputStream();
		 byte[] Imagedata =input.readAllBytes();
		 int bytesRead;
         int offset = 0;
         
         while ((bytesRead = input.read(Imagedata, offset, Imagedata.length - offset)) != -1) {
             offset += bytesRead;
         }
		 
         String base64Image = Base64.getEncoder().encodeToString(Imagedata);
         
         user.setEncodedImage(base64Image);
		 userservice.updateProfileImage(user,userId);
		 
		 
		 //update the user sesisio data
		 HttpSession session=request.getSession();
		 session.setAttribute("User",user);
		 response.sendRedirect("./EditProfileImageController");
		 
	}

}
