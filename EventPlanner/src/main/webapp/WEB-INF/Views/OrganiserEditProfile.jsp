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
	    <!--  <header class="header">
        <button type="button" class="nav_btn" id="nav_btn" onclick="openNavbar()">
            <img src="assets/icons/Menu.png" alt="menu-btn">
        </button>
        <div class="user-pfp">
            <button name="button" value="AddEvent" id="addEventBtn" class="addEventBtn-desk" onclick="openEventForm()">
                <img src="assets/icons/Plus.png" alt="Add event">
                <p>Add Event</p>             
            </button>
            <button name="button" value="AddEvent" id="addEventBtnmob" class="addEventBtn-mob" onclick="openEventForm()">
                <img src="assets/icons/Plus.png" alt="Add event">
            </button> 
            <div class="user-pfp-img">
                <form action="./PageRedirectController?page=org-profile" method="get">
                	<input type="hidden" name="page" value="org-profile">
                    <button class="user-pfp-img-btn" type="submit">
             			<c:if test="${User.getImageId().isEmpty()}">
             				<img src="assets/icons/MaleUser.png" alt="pfp">
             			</c:if>
             			<c:if test="${!User.getImageId().isEmpty()}">
             				<img src="uploads/${User.getImageName()}" alt="pfp">
             			</c:if>
                    </button>
                </form>                      
            </div> 
        </div>
    </header>-->
    <%@ include file="NavBar.jsp" %>
    <main>
 <!-- <div class="nav-background" id="nav-background">       
            <div class="nav-bar slideRight" id="nav-bar">
                <button type="button" class="nav-close" id="nav-close" onclick="closeNavbar()">
                    <img src="assets/icons/Multiply.png" alt="Close">
                </button>

                <div class="nav-item" id="Dashboard">
                    <form action="./PageRedirectController?" method="get">
                    	<input type="hidden" name="page" value="dashboard">
                        <button class="nav-link">Dashboard</button>
                    </form>
                   
                </div>
                <div class="nav-item" id="AllEvents">
                    <form action="" method="post">
                        <button class="nav-link">All Events</button>
                    </form>
                </div>
                <div class="nav-item" id="Something">
                    <form action="" method="post">
                        <button class="nav-link">Something</button>
                    </form>
                </div>
            </div>
        </div>

        <div id="Modal" class="modal">
            <div class="modal-content slideDown">
                <div class="closeBtn-con">
                    <button name="button" value="closeEventForm" id="closeEventForm" class="eventClose"onclick="closeEventForm()">
                        <img src="assets/icons/Multiply.png" alt="Close">
                    </button>
                </div>
                <div class="modal-header">
                   <h2>New Event</h2>
               </div>
                <div class="modal-body">
                     <form class="addEvent-form" action="./EventController" method="post">
                         <input type="hidden" name="triggerType" value="AddEvent"/>
                         <input type="hidden" value="${User.getId()}" name="userId">
                       
                         <div class="form-row">
                               <label for="EvenName">Event Name</label>
                               <input id="EvenName" name="EventName" type="text" />
                         </div>
   
                         <div class="form-row">
                               <label for="startDate">Start Date</label>
                               <input id="startDate" name="startDate" type="date" />
                         </div>
   
                             <div class="form-row">
                               <label for="endDate">End Date</label>
                               <input id="endDate" name="endDate" type="date" />
                         </div>
                 
                         <div class="form-row">
                               <label for="eventType">Event Type</label>
                               <select class="eventType-select" name="eventType" id="eventType">
                                   <option value="NULL">Select Type</option>
                  
                                 <c:forEach var="eventType" items="${etList}">
                                         <option value="${eventType.getId()}">${eventType.getType()} </option>
                                     </c:forEach>
                 
                               </select>
                          </div>
                          <input type="submit" class="button good" value="Save" />
                     </form>
                 </div>
            </div>
        </div>
        
       <div class="nav-desktop">
            <div class="logo">
                LOGO    
            </div>
            <div class="nav-desktop-item">
                <form action="./PageRedirectController" method="get">
                	<input type="hidden" name="page" value="dashboard">
                    <button class="nav-link">Dashboard</button>
                </form>
            </div>
            <div class="nav-desktop-item">
                <form action="" method="post">
                    <button class="nav-link">All Events</button>
                </form>
             </div>
             <div class="nav-desktop-item">
                    <form action="" method="post">
                        <button class="nav-link">Something</button>
                    </form>
             </div>
        </div>-->
		<%@ include file="NavMenus.jsp" %>
        <div class="user-info">
            <div class="user-pfp-edit">
                <img src="assets/icons/MaleUser.png" alt="profile-pic">
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
                <form class="userdetails-form" action="" method="post">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" name="name" id="name">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" name="email" id="email">
                    </div>
                    <div class="form-group">
                        <label for="phoneNumber">Phone Number</label>
                        <input type="text" name="phoneNumber" id="phoneNumber">
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