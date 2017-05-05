<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/css/airportStyle.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet" />
<title>Airport List</title>
<spring:url value="/Airports/List_of_Airports/${ap}" var="pageurl" />
</head>
<body>
	<div class="jumbotron text-center">
		<h1>Welcome to Airport List</h1>
	</div>
	<div class="container">
		<div class="row">
			<div id="tableSection">
				<c:set var="pageListHolder" value="${pagedAirportList}"
					scope="session" />
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th id="theadIATA">IATA</th>
							<th id="theadICAO">ICAO</th>
							<th id="theadName">NAME</th>
							<th id="theadLocation">LOCATION</th>
							<th id="theadTimezone">TIMEZONE</th>
							<th id="theadDST">DAYLIGHT SAVING TIME</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="ap" items="${pageListHolder.pageList}">
							<tr>
								<td>${ap.iata }</td>
								<td>${ap.icao }</td>
								<td>${ap.name }</td>
								<td>${ap.location }</td>
								<td>${ap.timeZone }</td>
								<td>${ap.dayLightSavingTime }</td>
							</tr>
						</c:forEach>
						<!-- staro
						<c:forEach items="${airportList}" var="ap">
							<tr>
								<td>${ap.iata }</td>
								<td>${ap.icao }</td>
								<td>${ap.name }</td>
								<td>${ap.location }</td>
								<td>${ap.timeZone }</td>
								<td>${ap.dayLightSavingTime }</td>
							</tr>
						</c:forEach>
						 -->
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
			<span style="float: left;"> <c:choose>
					<c:when test="${pageListHolder.firstPage}">Prev</c:when>
					<c:otherwise>
						<a href="${pageurl}/prev">Prev</a>
					</c:otherwise>
				</c:choose>
			</span> 
			<span> 
			<c:forEach begin="0" end="${pageListHolder.pageCount-1}" varStatus="loop"> &nbsp;&nbsp;
    			<c:choose>
					<c:when test="${loop.index == pageListHolder.page}">${loop.index+1}</c:when>
						<c:otherwise>
							<a href="${pageurl}/${loop.index}">${loop.index+1}</a>
						</c:otherwise>
				</c:choose>
    		&nbsp;&nbsp;
    		</c:forEach>
			</span>
			<span>
    			<c:choose>
       				<c:when test="${pageListHolder.lastPage}">Next</c:when>
        			<c:otherwise><a href="${pageurl}/next">Next</a></c:otherwise>
    			</c:choose>
   			 </span>
		</div>
	</div>
</body>
</html>