<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
	This is the login page
	This page contains a text field for username and another for password
	This page redirects to the Home page
-->

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width:device-width, initial-scale=1">
		<title>Login | PiPiHa Auction House</title>
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="./css/register.css" rel="stylesheet" type="text/css" />
		<!DOCTYPE html><html class=''>
<head><script src='//production-assets.codepen.io/assets/editor/live/console_runner-079c09a0e3b9ff743e39ee2d5637b9216b3545af0de366d4b9aad9dc87e26bfd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/events_runner-73716630c22bbc8cff4bd0f07b135f00a0bdc5d14629260c3ec49e5606f98fdd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/css_live_reload_init-2c0dc5167d60a5af3ee189d570b1835129687ea2a61bee3513dee3a50c115a77.js'></script><meta charset='UTF-8'><meta name="robots" content="noindex"><link rel="shortcut icon" type="image/x-icon" href="//production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" /><link rel="mask-icon" type="" href="//production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" /><link rel="canonical" href="https://codepen.io/fbrz/pen/obKle?limit=all&page=71&q=form" />


<style class="cp-pen-styles">
body {
  background-image: url("./picture/beijin11.jpg");
    background-size:100% 100%;
   background-attachment:fixed;
}
</style>
	</head>
	<body>
<div id="wrapper" >
  <img src="./picture/LOGOPIPI1.png";>
  <%
				String email = (String)session.getAttribute("email");
				String role = (String)session.getAttribute("role");
			
				//redirect to home page if already logged in
				if(email != null) {
					if(role.equals("manager")) {
						response.sendRedirect("managerHome.jsp");
					}
					else if(role.equals("customerRepresentative")) {
						response.sendRedirect("customerRepresentativeHome.jsp");
					}
					else {
						response.sendRedirect("home.jsp");	
					}
				}
				
				String status = request.getParameter("status");
				if(status != null) {
					if(status.equals("false")) {
						out.print("Incorrect Login credentials!");
					}
					else {
						out.print("Some error occurred! Please try again.");
					}
				}
			%>
  <form action="login">
    <div id="inputs">
      <div>
        <input type="email" name="username" placeholder="email" required>
        <div>
          <input type="password"  name="password" placeholder="password" required>
            <div>
              <input type="submit" value="login">
            </div>
        </div>
      </div>
    </div>
  </form>
   <div>
            <form  action="addCustomer_Register.jsp" method="POST">
      		<input type="submit" id = "register" value="register"/>
  			</form>
  			</div>
</div>
<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/4.1.3/bootstrap.min.js"></script>
	</body>
</html>