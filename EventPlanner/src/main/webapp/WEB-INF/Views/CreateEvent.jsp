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
<title>New Event</title>
</head>
<body>
<main>
	<div class="modal-content slideDown">

	   <div class="modal-header">
		
			<p>New Event</p>
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
</main>
</body>
</html>