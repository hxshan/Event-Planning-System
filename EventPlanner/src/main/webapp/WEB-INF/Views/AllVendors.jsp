<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.EventPlanner.Models.Vendor" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/Navs-Modals.css">
<link rel="stylesheet" type="text/css" href="css/AllVendors.css">

<title>Stores</title>
</head>

<body>
<%@ include file="NavBar.jsp" %>


	<main>

		<%@ include file="NavMenus.jsp" %>
		
		<div class="allStores-sec">
        <div class="serachbar">
            <form action="" method="get">
                <input type="search" class="search-field" name="search" id="search">
                <button type="submit" class="search-button">
                    Search
                </button>
            </form>
        </div>
        <div class="Stores-con">
            <h2>
                All Stores
            </h2>
            <div class="Stores">  
            
            <c:forEach var="vendor" items="${Vlist}"> 
                <form action="">
                	<input type="hidden" name="vendorId" value="${vendor.getId()}"> 
                    <button class="Store-card">
                        <div class="card-left">
                            <div class="card-img">
                            <c:choose>
                            	<c:when test="${empty vendor.getEncodedImage()}">
                            		<img src="assets/images/store.jpg" alt="">
                            	</c:when>
                            	<c:when test="${not empty vendor.getEncodedImage()}">
                            		<img src="data:image/jpeg;base64,${vendor.getEncodedImage()}" alt="">
                            	</c:when>
                            </c:choose>
                            </div>
                            <h2>${vendor.getName()}</h2>
                        </div>
                        <div class="card-info">
                            <div class="car-info-top">  
                                <p>
                                ${vendor.getDescription()}
                                </p>
                            </div>
                            <div class="car-info-bottom">
                                <p>Tel-No- ${vendor.getPhoneNumber()}</p>
                                <p>E-mail- ${vendor.getEmail()}</p>
                            </div>
                        </div>
                    </button>
                </form>
               </c:forEach>
            </div>
        </div>  
    </div>
	
	</main>
	<script src="scripts/NavigationModals.js"></script>
</body>
</html>