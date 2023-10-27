<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./ServiceController" method="post">
		<input type="hidden" name="triggerType" value="AddService"/>
    	<input type="hidden" name="userId" value="${User.getId()}"/>
    	<input type="hidden" name="TypeId" value="${Service.getTypeId()}"/>
     <div class="form-row">
          <label for="EvenName">Service Name</label>
          <input id="EvenName" name="Servicename" type="text" />
	</div>
	<div class="form-row">
          <label for="EvenName">Description</label>
          <input id="EvenName" name="discription" type="text" />
	</div>
	<div class="form-row">
          <label for="EvenName">Price</label>
          <input id="EvenName" name="price" type="text" />
	</div>
	<select class="eventType-select" name="eventType" id="eventType">
         <option value="NULL">Select Type</option>
                  
         <c:forEach var="ServiceType" items="${stypeList}">
              <option value="${ServiceType.getServiceId()}">${ServiceType.getType()} </option>
              </c:forEach>          
   </select>
	
    <button class="event-buttons" type="submit">
       Save
     </button>
 </form>
</body>
</html>