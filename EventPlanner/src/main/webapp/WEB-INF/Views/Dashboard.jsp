<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.EventPlanner.Models.User" %>
<%@ page import="com.EventPlanner.Models.Event" %>
<%@ page import="com.EventPlanner.Models.EventType" %>
<%@ page import="com.EventPlanner.Services.EventService" %>
<%@ page import="java.util.ArrayList,java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet"  type="text/css" href="css/UserDashboard.css" />
  	<link rel="stylesheet" type="text/css" href="css/Navs-Modals.css">
	<title>Dashboard</title>
</head>
<body>
	    <!-- <header class="header">
        <button type="button" class="nav_btn" id="nav_btn" onclick="openNavbar()">
            <img src="assets/icons/Menu.png" alt="menu-btn">
        </button>
        <div class="user-pfp">
            <button name="button" value="AddEvent" id="addEventBtn" class="addEventBtn-desk" onclick="openEventForm()">
                <img src="assets/icons/Plus.png" alt="Add event">
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
                        <img src="assets/icons/MaleUser.png" alt="pfp">
                    </button>
                </form>                      
            </div> 
        </div>
    </header> -->
    <%@ include file="NavBar.jsp" %>
    <main>
         <!-- <div class="nav-background" id="nav-background">       
            <div class="nav-bar slideRight" id="nav-bar">
                <button type="button" class="nav-close" id="nav-close" onclick="closeNavbar()">
                    <img src="assets/icons/Multiply.png" alt="Close">
                </button>

                <div class="nav-item" id="Dashboard">
                    <form action="./PageRedirectController" method="get">
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
                    <button name="button" value="closeEventForm" id="closeEventForm" class="eventClose" onclick="closeEventForm()">
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
        
        <div class="Dashboard-content">
            <div class="recentEvents-con" id="recentEvents-con">
                <h2>Dashboard</h2>
                <c:forEach var="event" items="${Elist}">
                <div class="event">
                    <h3>${event.getName()}</h3>
                    <div class="event-bottom">
                        <div class="eventType">
                            <img class="Event-icons" src="assets/icons/Event-star.png" alt="">
                            <p>Birthday Party</p> 
                        </div>
                        <div class="event-startdate">
                            <img class="Event-icons" src="assets/icons/Time.png" alt="">
                            <p>${event.getStartdate()}</p> 
                        </div>
                    </div>
                 	<div class="event-btns-con">
                        	<form action="./EventController" method="post">
                            	<input type="hidden" name="triggerType" value="EditEvent"/>
                            	<input type="hidden" name="eventId" value="${event.getId()}"/>
                            	<input type="hidden" name="userId" value="${User.getId()}"/>
                            	<button class="event-buttons" type="submit">
                                	<img src="assets/icons/view more btn.png" alt="">
                            	</button>
                        	</form>
                        	<form action="./EventController" method="post">
                            	<input type="hidden" name="triggerType" value="DeleteEvent"/>
                            	<input type="hidden" name="eventId" value="${event.getId()}"/>
                            	<input type="hidden" name="userId" value="${User.getId()}"/>
                            	<button class="event-buttons" type="submit">
                                	<img src="assets/icons/Delete btn.png" alt="">
                           	 	</button>
                        	</form>
                    	</div>
                </div>
                </c:forEach>
            </div>
            <div class="dashboard-bottom">
                <div class="Report-con" id="Report-con">
                    <h2 class="dashboard-title">Report</h2>
                    <div class="report">

                    </div>
                </div>
                <div class="calender" id="calender">
                    <h2 class="dashboard-title">Calender</h2>
                    <div class="calender-con">
        
                        <div class="calender-header">
                            <p class="cal-title" id="month"></p>
                            <p class="cal-title"id="year"></p>  
                        </div>
                        
                          <table>
                            <thead>
                              <tr>
                                <th class="caleder-day">S</th>
                                <th class="caleder-day">M</th>
                                <th class="caleder-day">T</th>
                                <th class="caleder-day">W</th>
                                <th class="caleder-day">T</th>
                                <th class="caleder-day">F</th>
                                <th class="caleder-day">S</th>
                              </tr>
                            </thead>
                            <tbody id="calendar-body">
                            </tbody>
                        
                          </table>
                    </div>
                </div>
            </div>
        </div>
    </main>
   <script src="scripts/NavigationModals.js"></script>
    <script>
      //Genarating calender
      const today = new Date()
            //console.log(today)
            const year = today.getFullYear()
            //console.log(year)
            const month = today.getMonth()
           // console.log(month)
            const firstDayOfMonth = new Date(year, month, 1)
            //console.log(firstDayOfMonth)
            const lastDayOfMonth = new Date(year, month + 1, 0)
            //console.log(lastDayOfMonth)
            const calendarBody = document.getElementById('calendar-body');

            const monthTitle= document.getElementById('month');
            const yearTitle=document.getElementById('year')
            const months=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"]
            monthTitle.textContent=months[month];
            yearTitle.textContent=year;



            for (let day = firstDayOfMonth; day <= lastDayOfMonth; day.setDate(day.getDate() + 1)) {
              const cell = document.createElement('td')
              cell.classList.add('round')
              cell.textContent = day.getDate()
              
              if (day.toDateString() === today.toDateString()) {
                cell.classList.add('today');
              }


              if (day.getDay() === 0) {
                const row = document.createElement('tr');
                row.appendChild(cell);
                calendarBody.appendChild(row);
              } else {
                calendarBody.lastElementChild.appendChild(cell);
              }
            }
    </script>
</body>
</html>