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
	<link rel="stylesheet" type="text/css" href="css/ServiceDetails.css">
<title>Event Service Details</title>
</head>
<body>
<%@ include file="NavBar.jsp" %>
<main>

	<%@ include file="NavMenus.jsp" %>
<div class="Service-section">
            <div class="service-image">
               <img src="assets/images/birthdayParty.png" alt="">
            </div>
            <div class="service-details">
                <h2>${currentService.getServiceName()}</h2>
                <h2 class="price">RS.${currentService.getPrice()}</h2>
                <p>${currentService.getDescription()}</p>

                     <form action="./EventServicesController" method="post">
                        <input type="hidden" name="serviceId" value="${currentService.getId()}">
                        <input type="hidden" name="eventId" value="${currentEvent.getId()}">
                        <input type="hidden" name="triggerType" value="addService">
                        <button type="submit">Select</button>
                     </form>
                    
            </div>
            <div class="vendor-details">
                <h2>${currentService_vendor.getName()}</h2>
                <p>${currentService_vendor.getDescription() }</p>
            </div>

        </div>


</main>


<script src="scripts/NavigationModals.js"></script>
</body>
</html>