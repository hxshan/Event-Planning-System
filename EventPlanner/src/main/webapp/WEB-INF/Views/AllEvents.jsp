<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.EventPlanner.Models.Event" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/Navs-Modals.css">
<link rel="stylesheet" type="text/css" href="css/AllEvents.css">
<title>All Events</title>
</head>
<body>
<%@ include file="NavBar.jsp" %>
<main>

	<%@ include file="NavMenus.jsp" %>
	
	<div class="allEvent-sec">
            <div class="Upcoming">
                <h2 class="page-titles">Upcoming Events</h2>
                <c:forEach var="event" items="${Elist}">
                	<form class="Event" action="" method="post">
                    	<button class="Event-card">
                        	<div class="card-img">
                            	<img src="event.jpg" alt="">
                        	</div>
                        	<div class="card-info">
                            	<div class="car-info-top">
                                	<h2>${event.getName()}</h2>
                            	</div>
                            	<div class="car-info-bottom">
                                	<h2>From<br>${event.getStartdate()}</h2>
                                	<h2>To<br>${event.getEnddate()}</h2>
                            	</div>
                        	</div>
                    	</button>
                	</form>
                </c:forEach>
                
               
            </div>
            <div class="Events PastEvents">
                <h2 class="page-titles">Past Events</h2>
                <form class="Event" action="" method="post">
                    <button class="Event-card">
                        <div class="card-img">
                            <img src="event.jpg" alt="">
                        </div>
                        <div class="card-info">
                            <div class="car-info-top">
                                <h2>Service Name</h2>
                            </div>
                            <div class="car-info-bottom">
                                <h2>From<br>2023/20/20</h2>
                                <h2>To<br>2023/20/20</h2>
                            </div>
                        </div>
                    </button>
                </form>
            </div>
        </div>
	
	
</main>
</body>
</html>