<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/Navs-Modals.css">
<link rel="stylesheet" type="text/css" href="css/AllServices.css">
<title>My Services</title>
</head>
<body>
 <%@ include file="VendorNavbarMenus.jsp" %>
		 <header class="header">
        <button type="button" class="nav_btn" id="nav_btn" onclick="openNavbar()">
            <img src="Menu.png" alt="menu-btn">
        </button>
          <div class="user-pfp">
        <form action="./PageRedirectController" >
        <input type="hidden" name="page" value="AddService"/>
        
        <button name="button" value="AddService" id="addServiceBtn" class="addEventBtn-desk" >
                <img src="Plus.png" alt="Add service">
                <p>Add Service
                </p>             
            </button>
            <button name="button" value="AddService" id="addServiceBtn" class="addEventBtn-mob" >
                <img src="Plus.png" alt="Add service">
            </button>
        
        </form>
                        <div class="user-pfp-img">
                <form action="" method="get">
                    <input type="hidden" name="page" value="org-profile">
                    <button class="user-pfp-img-btn" type="submit">
                        <img src="MaleUser.png" alt="pfp">
                    </button>
                </form>                      
            </div> 
        </div>
        </header>
        
        <div class="services-con">
                <h2>
                    My Services
                </h2>
                
                <div class="services">
                	<c:forEach var="service" items="${SVList}">
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
    
    
	

</body>
</html>