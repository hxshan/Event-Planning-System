<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" type="text/css" href="css/AddService.css">
<script src="../scripts/FromValidations.js"></script>
<title>Add Service</title>
</head>
<body>
<div class="formbold-main-wrapper">
    
    <div class="formbold-form-wrapper">
	<form action="./ServiceController" method="post" onsubmit = "return validateServiceDetailsForm()">
		<input type="hidden" name="triggerType" value="AddService"/>
    	<input type="hidden" name="userId" value="${User.getId()}"/>
     <div class="formbold-mb-5">
          <label for="vendor" class="formbold-form-label">
            Providing Service Name
          </label>
          <input type="text" name="Servicename" id="vendor" placeholder="Your Service Name" class="formbold-form-input"/>
        </div>
	
	<div class="formbold-mb-5">
            <label for="vendor" class="formbold-form-label">
              Service Description
            </label>
            <input type="text" name="description" id="vendor" placeholder="Service Description" class="formbold-form-input"/>
          </div>
	 <div class="formbold-mb-5">
            <label for="vendor" class="formbold-form-label">
              Price
            </label>
            <input type="number" name="price" id="vendor"placeholder="Price"class="formbold-form-input"/>
          </div>
          
         
   <div class="formbold-mb-5">
	<select class="eventType-select" name="TypeId"  id="eventType">
         <option value="NULL">Select Type</option>
        
        
                  
         <c:forEach var="ServiceType" items="${stypeList}">
              <option value="${ServiceType.getServiceId()}">${ServiceType.getType()} </option>
              </c:forEach>          
   </select>
   </div> <br>
	<div>
    <button class="formbold-btn" type="submit">
       Save
     </button>
    
  </div>
 </form> 
 <form action="./PageRedirectController" method="get" >
 <input type="hidden" name="page" value="NoService"/>
 <button  value="NoService"  class="formbold-btn2" type="submit" >
       Go Back
     </button></form>
 </div>
 </div>
</body>
</html>