<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.EventPlanner.Models.Event" %>
<%@ page import="com.EventPlanner.Models.Service" %>
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
                		
                		<img src="assets/images/event.png" alt="">
                        <h1>${currentEvent.getName()}</h1>
                        <h2>Held on<br><span>${currentEvent.getStartdate()}</span></h2>
                </div>
               
             </div>
             <div class="event-services-sec">
                <h2>Services</h2>
                <div class="event-services">
                	<c:forEach var="service" items="${EventServicesList}">
	                	<div class="service">
	                        <div class="service-details">
	                            <div class="service-image">
	                                <img src="assets/images/birthdayParty.png" alt="">
	                            </div>
	                            <div class="service-data">
	                                <p>${service.getServiceName()}</p>
	                                <div class="service-data-vendor">
	                                    <p>Vedor Name</p>
	                                    <p id="service-price">${service.getPrice()}</p>
	                                </div>
	                            </div>
	                        </div>
	                        <div class="service-status-btns">
	                            <div class="status">
	                                <p>TBD</p>
	                            </div>
	                            <div class="service-btns">
	                                <form id="deleteForm" action="./EventServicesController" method="post">
	                                    <input type="hidden" name="serviceId" value="${service.getId()}">
	                                    <input type="hidden" name="eventId" value="${currentEvent.getId()}">
	                                    <input type="hidden" name="triggerType" value="deleteService">
	                                    <button type="button" onclick="confirmDelete()">
	                                    DELETE
	                                       <!--  <img src="assets/icons/Delete btn.png" alt=""> -->
	                                    </button>
	                                </form>
	                            </div>
	                        </div>   
	                    </div>  	
                	</c:forEach>
                </div>
             </div>
             <form action="./PageRedirectController" class="new-service-form" method="get">
             	<input type="hidden" name="page" value="services">
                <button type="submit" class="add-Service-btn">
                    Add Service
                 </button> 
             </form>
             <div class="total-price">
                    <h2>Total</h2>
                    <h2 class="total">Rs.<span id="price"></span></h2>
               </div>
        </div>
	
</main>
<script src="scripts/NavigationModals.js"></script>
<script type="text/javascript">

var prices = document.querySelectorAll("#service-price");
const price = document.getElementById("price");

if (prices.length == 0) {
  price.innerText = "0.00";
} else {
  let tot = 0;
  prices.forEach((p) => {
    tot += parseFloat(p.textContent); 
  });
  price.innerText = tot.toFixed(2);
}

function confirmDelete() {
    
    if (confirm("Are you sure you want to delete this item?")) {
        document.getElementById("deleteForm").submit();
    } else {
    	
    }
}
	

</script>
</body>
</html>