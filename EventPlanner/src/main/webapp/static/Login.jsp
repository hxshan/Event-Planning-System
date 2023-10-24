<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="../css/login.css" />
    <script src="../scripts/FromValidations.js"></script>
<title>Login</title>

</head>
<body>
	    <main class="login-con">
            <form class="form" action="../LoginController" method="post" onsubmit="return validateLoginForm()"> 
                <h1 class="title">Login</h1>
                <div class="form-group">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" id="email" name="email" class="form-input" required>
                </div>
                <div class="form-group">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" id="password" name="password" class="form-input">
                </div>
                <!--not functional yet :( )-->
                <!-- <div class="form-group remember-me">
                    <input type="checkbox" id="remember" name="remember" class="form-checkbox">
                    <label for="remember" class="form-label">Remember me</label>
                </div> -->
                <button type="submit" id="submit" value="Submit" class="login-btn">Login</button>
                <p class="forgot-password"><a href="#" class="forgot-link">Forgot password?</a></p>
            </form>
        </main>
        

</body>


</html>