<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.EventPlanner.Models.Event" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/Navs-Modals.css">
	<link rel="stylesheet" type="text/css" href="css/EventDetails.css">
	<title>Event Details</title>
</head> 
<body>
<%@ include file="NavBar.jsp" %>
<main>

	<%@ include file="NavMenus.jsp" %>
	<div class="event-section">
             <div class="event-info-sec">
                <div class="event-hero">
                        <h1>${currentEvent.getName()}</h1>
                        <h2>${currentEvent.getStartdate()}</h2>
                </div>
                <div class="description">
                    <h2>Description</h2>
                    <p>Lorem ipsum dolor sit amet, consectetur
                        adipiscing elit. In ut lobortis orci, et sagittis quis
                        tincidunt non, sodales quis felis.
                        Vivamus luctus vitae eros eget faucibus. Sed aliquam erat luctu</p>
                </div>
             </div>
             <div class="event-services-sec">
                <h2>Services</h2>
                <div class="event-services">
                    <div class="service">
                        <div class="service-details">
                            <div class="service-image">
                                <img src="ELOGO.png" alt="">
                            </div>
                            <div class="service-data">
                                <p>Name</p>
                                <div class="service-data-vendor">
                                    <p>Vedor Name</p>
                                    <p>Price 1635465</p>
                                </div>
                            </div>
                        </div>
                        <div class="service-status-btns">
                            <div class="status">
                                <p>Approved</p>
                            </div>
                            <div class="service-btns">
                                <form action="" method="get">
                                    <input type="hidden" name="">
                                    <button type="submit">
                                        <img src="assets/icons/view more btn.png" alt="">
                                    </button>
                                </form>
                                <form action="" method="get">
                                    <input type="hidden" name="">
                                    <button type="submit">
                                        <img src="assets/icons/Delete btn.png" alt="">
                                    </button>
                                </form>
                            </div>
                        </div>   
                    </div>
      
                </div>
                
             </div>
             <form action="./PageRedirectController" class="new-service-form" method="get">
             	<input type="hidden" name="page" value="services">
                <button type="submit" class="add-Service-btn">
                    Add Service
                 </button> 
             </form>
             
        </div>
	
</main>
<script src="scripts/NavigationModals.js"></script>
</body>
</html>