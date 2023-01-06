<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<!DOCTYPE html>
<html>
<head>
 	<%@ include file="header.jsp" %> 
 	<script type="text/javascript" src="/js/bt.js"></script>  
</head>
<body>


 
<c:if test ="${getAllHolidayList.size()<1}">
	${notFound}
</c:if>

<div style="border: solid; margin-top: 50px;">	
	
		<form action="yearsonly" style="background-color: #01BAEF;">
			
			<label style="margin-left: 120px;" for="year">Filter - Year:</label> 
			<select id="yearOfList" name="year" onchange="changeFunc()" style="margin-right: 30px;">
				<option selected="selected" value="0">All</option>				
				<c:forEach items="${holidayDTOsDates}" var="holidayDateInYear">					
					<option value="${holidayDateInYear}">${holidayDateInYear}</option>					
				</c:forEach>				
			</select> 			
			<i class="fa fa-filter"></i><input style="margin-left: 10px; background-color: #01BAEF; border: none; color: white;" name="filter" type="submit" value="Filter">
		</form>


		<table class=" table" style="padding: 30px;">
			<thead class="thead-dark" style="border: none;">
				<tr	style="color: white; border: none; border-color: rgb(35, 35, 45);">
					<th style="width: 20px;">Action</th>
					<th></th>
					<th>Date</th>
					<th>Desc</th>
					<th>Type</th>
					<th>Location</th>
				</tr>
				<tr style="color: white; border: none;">
					<th><i class="fa fa-plus-circle"></i></th>
					<th><div></div></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
				</tr>								
				
			</thead>
			<tbody class=" table-light">

				<c:forEach items="${getAllHolidayList}" var="listHoliday">
					<tr>


						<td style="width: 5px;"><a
							href="del?id=${listHoliday.holidayid}"><button type="button"
									class="fa fa-trash-o" style="font-size: 24px;"></button></a></td>
						<td style="width: 5px;"><a
							href="edit?id=${listHoliday.holidayid}"><button type="button"
									class="fa fa-edit" style="font-size: 24px; color: blue"></button></a></td>
						<%-- <td style="width: 100px;">${listHoliday.holiday}</td> --%>						
						<td style="width: 100px;" ><fmt:formatDate value="${listHoliday.holiday}" pattern="MM-dd-yyyy"/></td>						
						<td style="width: 300px;">${listHoliday.holydayDesc}</td>
						<td style="width: 200px;">${listHoliday.holidayType}</td>
						<td style="width: 200px;">${listHoliday.loc}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>


</body>
</html>