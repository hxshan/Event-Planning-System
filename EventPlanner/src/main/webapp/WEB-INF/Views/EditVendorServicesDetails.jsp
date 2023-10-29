<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"  type="text/css" href="css/OrganiserInfo.css" />
<link rel="stylesheet" type="text/css" href="css/Navs-Modals.css">
<title>Edit Service Details</title>
</head>
<body>
	  

    <main>
		
        <div class="user-info">
        
          
            <div class="userdetails">
            <div class="user-pfp-edit">
            	<c:choose>
            		<c:when test="${empty User.getEncodedImage()}">
            			<div class="user-picture">
                    		<img src="assets/icons/MaleUser.png" alt="profile-pic">
               			</div>
            		</c:when>
            		<c:when test="${not empty User.getEncodedImage()}">
            			<div class="user-picture">
            			<img src="data:image/jpeg;base64,${User.getEncodedImage()}" alt="Image">	
               			</div>
            		</c:when>
            	</c:choose>
            	   <form class="pfp-form" action="./EditProfileImageController" method="post" enctype="multipart/form-data">
                    <label for="profile-pic-input" class="imageChange-label">
                        Edit
                    </label>
                    <input type="file" class="profile-pic-input" name="profile-pic-input" id="profile-pic-input"> 
                    <input type="hidden" value="${User.getId()}" name="userId">           
                    <button type="submit" class="submit-btn-img">
                        Save image
                    </button>
                </form>
            </div>
            	
                <form class="userdetails-form" action="./EditVendorServiceDetails" method="post">
                	<input type="hidden" value="${currentService.getId()}" name="Id">
                	<input type="hidden" value="${User.getId()}" name="userId">
                    <div class="form-group">
                    
                        <label for="name">Service Name</label>
                        <input type="text" name="Servicename" id="Servicename" value="${currentService.getServiceName()}">
                    </div>
                    <div class="form-group">
                        <label for="email">Description</label>
                        <input type="text" name="description" id="description" value="${currentService.getDescription()}">
                    </div>
                    <div class="form-group">
                        <label for="phoneNumber">Price</label>
                        <input type="number" name="price" id="price" value="${currentService.getPrice()}">
                    </div>

                    <div class="form-group">
                        <button type="submit" class="submit-btn" name="submit">Save</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
    <script src="scripts/NavigationModals.js"></script>
</body>
</html>