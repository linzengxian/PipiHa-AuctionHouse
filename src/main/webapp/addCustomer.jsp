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
	<style>
body {
  background-image: url("./picture/beijin16.jpg");
    background-size:100% 100%;
   background-attachment:fixed;
}
</style>
</head>
<body>
	<div id="wrapper" >
	 <h1>Add Customer:</h1>
	<div id="inputs">
	<form action="Register" method="POST">
		<div><%	String status = request.getParameter("status");
		if(status != null) {
			if(status.equals("false")) {
				out.print("Incorrect Login credentials!");
				
			}
			else {
				out.print("Some error occurred! Please try again.");
			}
		} %></div>
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
   	  <div>
	    <input type="text" id="customerRating" name="customerRating" placeholder="Rating">
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