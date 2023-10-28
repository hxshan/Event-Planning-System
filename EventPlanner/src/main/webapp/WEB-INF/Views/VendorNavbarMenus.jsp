<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/Navs-Modals.css">
<title></title>
</head>
<body>
<div class="nav-background" id="nav-background">       
            <div class="nav-bar slideRight" id="nav-bar">
                <button type="button" class="nav-close" id="nav-close" onclick="closeNavbar()">
                    <img src="assets/icons/Multiply.png" alt="Close">
                </button>

                <div class="nav-item" id="Dashboard">
                    <form action="./PageRedirectController" method="get">
                    	<input type="hidden" name="page" value="VendorDashboard">
                        <button class="nav-link">Dashboard</button>
                    </form>
                   
                </div>
                <div class="nav-item" id="AllVendorServices">
                    <form action="./PageRedirectController" method="get">
                    <input type="hidden" name="page" value="AllVendorServices">
                        <button class="nav-link">My Services</button>
                    </form>
                </div>
                <div class="nav-item" id="Something">
                    <form action="" method="post">
                        <button class="nav-link">Orders</button>
                    </form>
                </div>
            </div>
        </div>

       <div class="nav-desktop">
            <div class="logo">
                LOGO    
            </div>
            <div class="nav-desktop-item">
                <form action="./PageRedirectController" method="get">
                	<input type="hidden" name="page" value="VendorDashboard">
                    <button class="nav-link">Dashboard</button>
                </form>
            </div>
            <div class="nav-desktop-item">
                <form action="./PageRedirectController" method="get">
                <input type="hidden" name="page" value="VendorAllServices">
                <input type="hidden" name="vendorid" value="${User.getId()}">
                    <button class="nav-link">My Services</button>
                </form>
             </div>
             <div class="nav-desktop-item">
                    <form action="" method="post">
                        <button class="nav-link">Orders</button>
                    </form>
             </div>
        </div>
</body>
</html>