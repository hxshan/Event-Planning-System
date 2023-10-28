<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form class="pfp-form" action="./Controller" method="post" enctype="multipart/form-data">
                    <label for="profile-pic-input" class="imageChange-label">
                        Edit
                    </label>
                    <input type="file" class="profile-pic-input" name="profile-pic-input" id="profile-pic-input"> 
                    <input type="hidden" value="${User.getId()}" name="userId">           
                    <button type="submit" class="submit-btn-img">
                        Save image
                    </button>
                </form>
		

</body>
</html>