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
		<!DOCTYPE html><html class=''>
<head><script src='//production-assets.codepen.io/assets/editor/live/console_runner-079c09a0e3b9ff743e39ee2d5637b9216b3545af0de366d4b9aad9dc87e26bfd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/events_runner-73716630c22bbc8cff4bd0f07b135f00a0bdc5d14629260c3ec49e5606f98fdd.js'></script><script src='//production-assets.codepen.io/assets/editor/live/css_live_reload_init-2c0dc5167d60a5af3ee189d570b1835129687ea2a61bee3513dee3a50c115a77.js'></script><meta charset='UTF-8'><meta name="robots" content="noindex"><link rel="shortcut icon" type="image/x-icon" href="//production-assets.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" /><link rel="mask-icon" type="" href="//production-assets.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" /><link rel="canonical" href="https://codepen.io/fbrz/pen/obKle?limit=all&page=71&q=form" />


<style class="cp-pen-styles">@import url(https://fonts.googleapis.com/css?family=Raleway:400,700);
html, body {
  height: 100%;
  margin: 0;
}

body {
  background-image: url("./picture/beijin7.jpg");
    background-size:100% 100%;
   background-attachment:fixed;
}

:focus {
  outline: 0;
}

#wrapper {
  -webkit-perspective: 500px;
          perspective: 500px;
  position: absolute;
  top: 50%;
  left: 50%;
  text-align: center;
  -webkit-transform: translate3d(-50%, -50%, 0);
          transform: translate3d(-50%, -50%, 0);
}

h1 {
  color: #416171;
  font-size: 43px;
  margin: 0;
}

h2 {
  color: #349E97;
  margin: 0;
}

form {
  margin: 35px 0;
}

#inputs {
  height: 127px;
  -webkit-transition: height .5s ease-in-out;
  transition: height .5s ease-in-out;
}
#inputs div {
  height: 41px;
  -webkit-transform-origin: 0 0;
          transform-origin: 0 0;
  -webkit-transition: -webkit-transform .5s ease-in-out;
  transition: -webkit-transform .5s ease-in-out;
  transition: transform .5s ease-in-out;
  transition: transform .5s ease-in-out, -webkit-transform .5s ease-in-out;
}
#inputs > div > div > div {
  -webkit-transform: rotateX(0deg);
          transform: rotateX(0deg);
  -webkit-transform-style: preserve-3d;
          transform-style: preserve-3d;
}
#inputs > div > div > div input:nth-child(2),
#inputs > div > div > div > div input:nth-child(2) {
  -webkit-transform: translateZ(-1px) rotateX(180deg);
          transform: translateZ(-1px) rotateX(180deg);
}
#inputs > div > div > div > div {
  -webkit-transform: translateY(-41px) rotateX(0deg);
          transform: translateY(-41px) rotateX(0deg);
  -webkit-transform-style: preserve-3d;
          transform-style: preserve-3d;
}

input {
  background: #FFFEFC;
  border: 0;
  box-sizing: border-box;
  display: block;
  font-family: Raleway, sans-serif;
  font-weight: 600;
  font-size: 12px;
  margin: 0 auto;
  padding: 13px;
  -webkit-transition: all .2s ease-in-out;
  transition: all .2s ease-in-out;
  width: 300px;
  -webkit-transform-origin: 0 0;
          transform-origin: 0 0;
  -webkit-font-smoothing: antialiased;
}
input:hover {
  background: #f3f3f3;
}
input:focus {
  background: #EAEAEA;
}
input[type=submit] {
  background: #43434C;
  color: #FFFEFC;
  cursor: pointer;
}
input[type=radio] {
  display: none;
}

input:checked[value=reset] ~ #inputs {
  height: 84px;
}
input:checked[value=reset] ~ #labels {
  margin-top: -10px;
}
input:checked[value=reset] ~ #inputs div > div > div {
  -webkit-transform: rotateX(180deg);
          transform: rotateX(180deg);
}
input:checked[value=reset] ~ #inputs div > div > div > div {
  -webkit-transform: translateY(-41px) rotateX(180deg);
          transform: translateY(-41px) rotateX(180deg);
}
input:checked[value=reset] ~ #labels label[for=reset],
input:checked[value=reset] ~ #labels label[for=register],
input:checked[value=reset] ~ #labels label[for=login]:first-child {
  -webkit-transition: opacity .5s;
  transition: opacity .5s;
  opacity: 0;
}
input:checked[value=register] ~ #inputs {
  height: 170px;
}
input:checked[value=register] ~ #labels {
  margin-top: 30px;
}
input:checked[value=register] ~ #labels label[for=reset],
input:checked[value=register] ~ #labels label[for=register],
input:checked[value=register] ~ #labels label[for=login]:nth-child(3) {
  -webkit-transition: opacity .5s;
  transition: opacity .5s;
  opacity: 0;
}
input:checked[value=login] ~ #labels {
  margin-top: 11px;
}
input:checked[value=login] ~ #inputs div > div > div > div {
  -webkit-transform: translateY(-41px) rotateX(180deg);
          transform: translateY(-41px) rotateX(180deg);
}
input:checked[value=login] ~ #labels label[for=login] {
  -webkit-transition: opacity .5s;
  transition: opacity .5s;
  opacity: 0;
}

#labels {
  -webkit-transition: margin .5s ease-in-out;
  transition: margin .5s ease-in-out;
}

label {
  display: block;
  font-size: 14px;
  color: #FFFFBB;
  margin-bottom: 5px;
  font-weight: 600;
  height: 16px;
  -webkit-transition: opacity 1s .3s;
  transition: opacity 1s .3s;
  overflow: hidden;
}
label span {
  cursor: pointer;
  color: gold;
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