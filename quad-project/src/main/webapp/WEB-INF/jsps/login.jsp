<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>  
  	<%@ include file="header.jsp" %>
</head>

<body>
<form id="form" action="login" method="get" >
	<div class="div-main">
		
		
		<div class="div-main mb-3">
			<label class="lab-main">Login By:</label>
			<input id="login" type="text" name="login" class="form-control hid" required="required">
		</div>
		
		
		
		<button type="submit" class="btn btn-outline-primary  update">Forward </button>		
	</div>
</form>


</body>
</html>