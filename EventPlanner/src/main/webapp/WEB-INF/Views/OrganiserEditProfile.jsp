<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"  type="text/css" href="css/OrganiserInfo.css" />
<link rel="stylesheet" type="text/css" href="css/Navs-Modals.css">
<title>User Profile</title>
</head>
<body>
	  
    <%@ include file="NavBar.jsp" %>
    <main>
		<%@ include file="NavMenus.jsp" %>
        <div class="user-info">
            <div class="user-pfp-edit">
            	<c:choose>
            		<c:when test="${User.getImageId()==NULL}">
            			<div class="user-picture">
                    		<img src="assets/icons/MaleUser.png" alt="profile-pic">
               			</div>
            		</c:when>
            		<c:when test="${User.getImageId()!=NULL}">
            			<div class="user-picture">
                    		<img src="uploads/${User.getImageName()}" alt="profile-pic">
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
            <div class="userdetails">
                <form class="userdetails-form" action="./UpdateUserController" method="post">
                	<input type="hidden" value="${User.getId()}" name="userId">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" name="name" id="name" value="${User.getName()}">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" name="email" id="email" value="${User.getEmail()}">
                    </div>
                    <div class="form-group">
                        <label for="phoneNumber">Phone Number</label>
                        <input type="text" name="phoneNumber" id="phoneNumber" value="${User.getPhoneNumber()}">
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