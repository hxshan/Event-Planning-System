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
 
<title>User Profile</title>
</head>
<body>
	  
    <%@ include file="NavBar.jsp" %>
    <main>
		<%@ include file="NavMenus.jsp" %>
        <div class="user-info">
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
            <div class="userdetails">
                <form class="userdetails-form" action="./UpdateUserController" method="post" onsubmit="return validateUserUpdateForm()">
                	<input type="hidden" value="${User.getId()}" name="userId">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" name="name" id="name" value="${User.getName()}">
                    </div>
                    <div class="form-group" style="display:none">
                        <label for="email">Email</label>
                        <input type="email" name="email" id="email" value="${User.getEmail()}">
                    </div>
                    <div class="form-group">
                        <label for="phoneNumber">Phone Number</label>
                        <input type="tel" name="phoneNumber" id="phoneNumber" value="${User.getPhoneNumber()}">
                    </div>

                    <div class="form-group">
                        <button type="submit" class="submit-btn" name="submit">Save</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
    <script src="scripts/NavigationModals.js"></script>
    <script type="text/javascript">
    
	function validateUserUpdateForm() {
		var name = document.getElementById("name").value;
		var email = document.getElementById("email").value;
		var PhoneNumber = document.getElementById("phoneNumber").value;
		var phonePattern=/^[0]{1}[7]{1}[01245678]{1}[0-9]{7}$/;
		
		var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
		var password = document.getElementById("password").value;
		if (name.trim() === "" || email.trim() ==="" || password.trim() ===""||PhoneNumber==="" ) {
			alert("All fields must be filled out!");
			return false;
		}
		if (!phonePattern.test(PhoneNumber)) {
  			alert("Invalid phone number");
    		return false;
 		}
		if (!emailPattern.test(email)) {
  			alert("Invalid email address");
    		return false;
 		}
	
		return true;
	}
 
 </script>
</body>
</html>