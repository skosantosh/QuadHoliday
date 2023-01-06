<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="header.jsp" %> 
  
</head>

<body>
${message}
<form action="update-Delete" method="get" >
	<div class="div-main">
		<div class="div-main mb-3">
			<label class="lab-main">Holiday ID:</label>
			<input type="text" name="holidayid" readonly="readonly"  value="${holidayData.holidayid}" class="form-control hid">
		</div>
		
		 <div class="div-main mb-3">
			<label class="lab-main">Location:</label>
			<input type="text" name="loc" readonly="readonly"  value="${holidayData.loc}" class="form-control hid">
			<%-- <select class="form-control select" name="loc" aria-label="Choose Group" required="required">
   			<option selected>${holidayData.loc}</option>
   			<c:forEach items="${locations}" var="loc">
   			<option value="${loc.location}">${loc.location}
   				</option>	    			
   			</c:forEach>
   		
   		</select>	 --%>
   		
		</div>
		
		<div class="div-main mb-3">
			<label class="lab-main">Date:</label>
			<input type="date" name="holiday" readonly="readonly" value="${holidayData.holiday}" class="form-control hid" required="required">
		</div>
		
		<div class="div-main mb-3">
			<label class="lab-main">Holiday Type:</label>
			<input type="text" name="holydayDesc" readonly="readonly"  value="${holidayData.holidayType}" class="form-control hid">
			<%-- <select class="form-control select" name="holidayType" aria-label="Choose Group" required="required">
   			<option selected>${holidayData.holidayType}</option>
   			<c:forEach items="${holidaysType}" var="holidayT">
   			<option value="${holidayT.holidayName}">${holidayT.holidayName}
   				</option>	    			
   			</c:forEach>
   		
   		</select>	 --%>
		</div>
		
		
		
		<div class="div-main mb-3">
			<label class="lab-main">Description:</label>
			<input type="text" name="holydayDesc" readonly="readonly" value="${holidayData.holydayDesc}" class="form-control hid">	
		</div>
		
		
		<input type="text" hidden="true" name="updByUser" value="${userName}" class="form-control hid">
		<input type="text" hidden="true" name="ctrByUser" value="${holidayData.ctrByUser}" class="form-control hid">
		<input type="text" hidden="true" name="crtByTs" value="${holidayData.crtByTs}" class="form-control hid">
		
		<button type="submit" class="btn btn-outline-primary  update">Delete </button>
		
	</div>
</form>


</body>
</html>