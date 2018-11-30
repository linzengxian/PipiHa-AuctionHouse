<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
	This is the Add Customer page
	This page displays fields to add a Customer 
	The details are sent to the AddCustomerController class in resources package
-->


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Add Customer</title>
	<link href="webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />	
	<script src="webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
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
	 <img src="./picture/pipiregister.png";>
	<div id="inputs">
	<form action="addCustomer" method="POST">
	  <div >
	    <input type="email" id="customerEmail" name="customerEmail" placeholder="Enter email" required>
	  </div>
	  <div >
	    <input type="password" id="customerPassword" name="customerPassword" placeholder="Password" required>
	  </div>
  	  <div >
	    <input type="text" id="customerFirstName" name="customerFirstName" placeholder="First Name" required>
	  </div>
  	  <div >
	    <input type="text" id="customerLastName" name="customerLastName" placeholder="Last Name" required>
	  </div>
   	  <div >
	    <input type="text" id="customerAddress" name="customerAddress" placeholder="Address" required>
	  </div>
   	  <div >
	    <input type="text" id="customerCity" name="customerCity" placeholder="City" required>
	  </div>
   	  <div >
	    <input type="text" id="customerState" name="customerState" placeholder="State" required>
	  </div>
   	  <div >
	    <input type="text" id="customerZipcode" name="customerZipcode" placeholder="Zipcode" required>
	  </div>
   	  <div >
	    <input type="text" id="customerTelephone" name="customerTelephone" placeholder="Telephone number" required>
	  </div>
	  <div >
	    <input type="text" id="customerSSN" name="customerSSN" placeholder="SSN" required>
	  </div>
	  <div >
	    <input type="text" id="customerCreditCard" name="customerCreditCard" placeholder="Credit Card" required>
	  </div>
   	  <div  style="display:none">
	    <input type="text" id="customerRating" name="customerRating" placeholder="Rating" value="5">
	  </div>
	  <input type="submit" value="Register">
	</form>
	<div>
		<form action="home.jsp">
			<input type="submit" value="Home"/>
		</form>
	</div>
</div>
</div>
</body>
</html>