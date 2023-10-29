<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<link rel="stylesheet"  type="text/css" href="css/UserDashboard.css" />
  	<link rel="stylesheet" type="text/css" href="css/Navs-Modals.css">
<title></title>
</head>
<body>
	  <header class="header">
        <button type="button" class="nav_btn" id="nav_btn" onclick="openNavbar()">
            <img src="assets/icons/Menu.png" alt="menu-btn">
        </button>
        <div class="user-pfp">
        <form action="./PageRedirectController" >
        <input type="hidden" name="page" value="AddService"/>
        
        <button name="button" value="AddService" id="addServiceBtn" class="addEventBtn-desk" >
                <img src="assets/icons/Add-Btn.png" alt="Add service">
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
                        <img src="assets/icons/MaleUser.png" alt="pfp">
                    </button>
                </form>                      
            </div> 
        </div>
    </header>
  
</body>
</html>