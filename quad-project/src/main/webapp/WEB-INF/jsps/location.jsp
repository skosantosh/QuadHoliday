<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <%@ include file="header.jsp" %>   	
</head>

<body>
<form id="form" action="savelocation" method="post" >
	<div class="div-main">
		
		
		<div class="div-main mb-3">
			<label class="lab-main">Location:</label>
			<input id="location" type="text" name="location" class="form-control hid" required="required">
		</div>
		
		
		
		<button type="submit" class="btn btn-outline-primary  update">Save Location </button>
		<div class="container mt-3">		 
		  	<a href="clocktime" class="btn btn-success">Go to Update</a>
		  	<a href="holiday" class="btn btn-success">Go to Holiday</a>	
		</div>
	</div>
</form>


</body>
</html>