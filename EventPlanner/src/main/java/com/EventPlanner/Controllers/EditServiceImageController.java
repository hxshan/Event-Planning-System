package com.EventPlanner.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import com.EventPlanner.Services.AddVendoService_Service;

/**
 * Servlet implementation class EditServiceImageController
 */
public class EditServiceImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServiceImageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddVendoService_Service Aservice=new AddVendoService_Service();
		
		
		int Id=Integer.parseInt(request.getParameter("userId"));
		Part image=request.getPart("profile-pic-input");
		User user=userservice.getUserDetailsById(userId);
		
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
