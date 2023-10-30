<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet"  type="text/css" href="css/UserDashboard.css" />
  	<link rel="stylesheet" type="text/css" href="css/Navs-Modals.css">
<title></title>
</head>
<body>
<header class="header">
        <button type="button" class="nav_btn" id="nav_btn" onclick="openNavbar()">
            <img src="assets/icons/Menu.png" alt="menu-btn">
        </button>
        <div class="user-pfp">
            <button name="button" value="AddEvent" id="addEventBtn" class="addEventBtn-desk" onclick="openEventForm()">
                <img src="assets/icons/Add-Btn.png" alt="Add event">
                <p>Add Event
                </p>             
            </button>
            <button name="button" value="AddEvent" id="addEventBtnmob" class="addEventBtn-mob" onclick="openEventForm()">
                <img src="assets/icons/Plus.png" alt="Add event">
            </button>
            <div class="user-pfp-img">
                <form action="./PageRedirectController" method="get">
                	<input type="hidden" name="page" value="org-profile">
                    <button class="user-pfp-img-btn" type="submit">
                    <c:choose>
                    	<c:when test="${empty User.getEncodedImage()}">
                    		<img src="assets/icons/MaleUser.png" alt="pfp">
                    	</c:when>
                    	<c:when test="${not empty User.getEncodedImage()}">
                    		<img src="data:image/jpeg;base64,${User.getEncodedImage()}" alt="Image">
                    	</c:when>
                    </c:choose>       
                    </button>
                </form>  
                                                 
            </div> 
        </div>
    </header>

</body>
</html>