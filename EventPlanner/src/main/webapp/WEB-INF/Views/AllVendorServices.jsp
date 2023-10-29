<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Navs-Modals.css">
<link rel="stylesheet" type="text/css" href="css/AllServices.css">
<link rel="stylesheet" type="text/css" href="css/AllEvents.css">
<title>My Services</title>
</head>
<body>
<%@ include file="VendorNavbar.jsp" %>
<main>
 <%@ include file="VendorNavbarMenus.jsp" %>
		
        
        <div class="allEvent-sec">
                <h1>
                    My Services
                </h1>
                
                <div class="Upcoming">
                
                	<c:forEach var="service" items="${SVList}">
                	
                		<div class="Event-card">
                	        <div class="card-img">
                	            <img src="assets/images/service-placeholder.jpg" alt="">
                	        </div>
                	        <div class="card-info">
                	            <div class="car-info-top">
                	                <h2>${service.getServiceName()}</h2>
                	               
                	            </div>
                	            <div class="car-info-bottom">
                	                <p>${service.getDescription()}</p>
                	                <h2>${service.getPrice()}</h2>    
                	                
                	                
                	            </div>
                	            
                	            <div class="event-btns-con">
                    			    	<form action="./PageRedirectController" method="get">
                            				<input type="hidden" name="page" value="EditService"/>
                            				<input type="hidden" name="serviceId" value="${service.getId()}"/>
                            				<button class="event-buttons" type="submit">
                                				<img src="assets/icons/view more btn.png" alt="">
                            				</button>
                        				</form>
                        				<form action="./VendorServiceController" method="post">
                            				<input type="hidden" name="triggerType" value="DeleteService"/>
                            				<input type="hidden" name="serviceId" value="${service.getId()}"/>
                            				<input type="hidden" name="vendorId" value="${User.getId()}"/>
                            				<button class="event-buttons" type="submit">
                                				<img src="assets/icons/Delete btn.png" alt="">
                           	 				</button>
                        				</form>
                    				</div>
                	        </div>
                	    </div>
                	
                	</c:forEach>
                	   
                </div>
         
            </div>  
    
    
	
</main>
</body>
</html>