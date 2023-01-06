<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
  <%@ include file="header.jsp" %>   	
</head>

<body onload="myFuction">
<form id="form" action="save-past-future" method="post" >
	<div class="div-main">
		
		
		<div class="div-main mb-3">			
			<input id="location" type="text" hidden="true" name="id" class="form-control hid" value="1">
			<!-- <input id="location" type="number" name=pastYear class="form-control hid" required="required"> -->
			<div class="div-main mb-3">
					<label class="lab-main">Past Year:</label>
					<input id="pYear" type="number" name=pastYear value="${diffYear.pastYear}" class="form-control hid" min="1" max="7" required="required">
			</div>
			<div class="div-main mb-3">
				<label class="lab-main">Future Year:</label>
				<input   id="fYear" type="number" name="futureYear" value="${diffYear.futureYear}" class="form-control hid" min="1" max="7" required="required">
			</div>
			
		</div>	
		
		
		<div class="container mt-3">
				<c:choose>
					<c:when test="${(userName=='Admin')||(userName=='admin')}">
						<button id="mySubmit" style="margin-top: 5px;" type="submit" class="btn btn-outline-primary  update">Save Diff.Year</button>
					</c:when>
					<c:otherwise>
						<button disabled="disabled" id="mySubmit" style="margin-top: 5px;" type="submit" class="btn btn-outline-primary  update">Save Diff.Year</button>
					</c:otherwise>
				</c:choose>				
					
			
		  	<a href="clocktime" style="margin-left: 5px; margin-top: 5px;" class="btn btn-success">Go to Update</a>
		  	<a href="location" style="margin-left: 5px; margin-top: 5px;" class="btn btn-success">Go to Location</a>
		  	<a href="holiday" style="margin-left: 5px; margin-top: 5px;" class="btn btn-success">Go to Holiday</a>	
		  	
		</div>
	</div>
</form>


</body>
</html>