<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/Navs-Modals.css">
<title></title>
</head>
<body>
<div class="nav-background" id="nav-background">       
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
                          <button type="submit">Save</button>
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
        </div>
</body>
</html>