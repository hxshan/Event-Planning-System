<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.EventPlanner.Models.Event" %>
<%@ page import="com.EventPlanner.Models.Service" %>
<%@ page import="com.EventPlanner.Services.Services_Service" %>
<%@ page import="java.util.ArrayList,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/Navs-Modals.css">
	<link rel="stylesheet" type="text/css" href="css/AllServices.css">
<title>Services</title>
</head>
<body>
	
	<%@ include file="NavBar.jsp" %>
<main>
	<%@ include file="NavMenus.jsp" %>
	
	<div class="allservices-sec">
            <div class="serachbar">
                <form action="" method="get">
                    <input type="search" class="search-field" name="search" id="search">
                    <button type="submit" class="search-button">
                        Search
                    </button>
                </form>
            </div>
            <div class="services-con">
                <h2>
                    Services
                </h2>
                
                <div class="services">
                	<c:forEach var="service" items="${SList}">
                		<div class="service-card">
                	        <div class="card-img">
                	            <img src="assets/images/service-placeholder.jpg" alt="">
                	        </div>
                	        <div class="card-info">
                	            <div class="car-info-top">
                	                <h2>${service.getServiceName()}</h2>
                	                <p>Vendor</p>
                	            </div>
                	            <div class="car-info-bottom">
                	                <p>${service.getDescription()}</p>
                	                <h2>${service.getPrice()}</h2>      
                	            </div>
                	        </div>
                	    </div>
                	</c:forEach> 
                </div>
         
            </div>  
        </div>
	
	
	
</main>
<script src="scripts/NavigationModals.js"></script>
</body>
</html>