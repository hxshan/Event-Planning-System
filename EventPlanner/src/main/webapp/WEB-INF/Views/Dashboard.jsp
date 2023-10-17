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
	<link rel="stylesheet" href="css/General.css" />
	<link rel="stylesheet" href="css/UserDashboard.css" />
	<title>Dashboard</title>
</head>
<body>
	<header>
		<h1>Dashboard</h1>
		<p>Welcome ${User.getName()}</p>
	</header>
	 <main>
	 <div id="Modal" class="modal">
		 <div class="modal-content slideDown">
			<button name="button" value="closeEventForm" id="closeEventForm" class="button_round -red">x</button>
	   		<div class="modal-header">
				<h2>New Event</h2>
			</div>
				<div class="modal-body">
   					<form action="./EventController" method="post">
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
		<div class="EventList-con">
		<!-- <form action="./PageRedirectController" method="get"> -->
		
      		<button name="button" value="AddEvent" id="addEventBtn" class="button -blue">Add Event</button>
      		
     	<!-- </form> -->
		
          <table class="EventTable">
           	<thead>
            	<tr>
              		<th>Name</th>
              		<th>Start Date</th>
              		<th>End Date</th>
              		<th>Action</th>
            	</tr>
          	</thead>
          	 <tbody>
     		 	<c:forEach var="event" items="${Elist}">
   			 		<tr>
              			<td class="table-data">${event.getName()}</td>
              			<td class="table-data">${event.getStartdate()} </td>
              			<td class="table-data">${event.getEnddate()}</td>
             			<td class="table-data">  
                			<div class="Event-Btn-con">
                  				<form action="./EventController" method="post">
                    				<button class="button -green">Edit</button>
                    				<input type="hidden" name="triggerType" value="EditEvent" />
                    				<input type="hidden" name="eventId" value="${event.getId()}" />
                    				<input type="hidden" name="userId"  value="${User.getId()}"/>
                 				</form>
                  				<form action="./EventController" method="post">
                    				<button class="button -red">Delete</button>
                    				<input type="hidden" name="triggerType" value="DeleteEvent"/>
                    				<input type="hidden" name="userId"  value="${User.getId()}"/>
                    				<input type="hidden" name="eventId" value="${event.getId()}" />
                  				</form>
                			</div>
              			</td>
            		</tr>
				</c:forEach>
        		</tbody>
        	</table>

      	</div>
    </main>
    
    <script>
    const openModalBtn = document.querySelector("#addEventBtn");
    const closeModalBtn = document.querySelector("#closeEventForm");
    const modal = document.querySelector("#Modal");
    
    openModalBtn.addEventListener('click',()=>{
        modal.style.display = "flex";
      })

      closeModalBtn.addEventListener('click',()=>{
        modal.style.display = "none";
      })
    window.onclick = function(event) {
	if (event.target == modal) {
		modal.style.display = "none"
	}
}
    </script>
</body>
</html>