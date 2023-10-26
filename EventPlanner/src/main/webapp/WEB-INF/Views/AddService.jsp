<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./ServiceController" method="post">
    	<input type="hidden" name="userId" value="${User.getId()}"/>
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
    <button class="event-buttons" type="submit">
       Save
     </button>
 </form>
</body>
</html>