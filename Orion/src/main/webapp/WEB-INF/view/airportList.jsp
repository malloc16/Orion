<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/css/airportStyle.css' />" rel="stylesheet" />
<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet" />
<title>Airport List</title>
</head>
<body>

<h2>Welcome to Airport List</h2>
<div id = "tableSection">
	<table class="table table-hover table-bordered">
		<thead>
			<tr>
				<th id = "theadIATA">IATA</th>
				<th id = "theadICAO">ICAO</th>
				<th id = "theadName">NAME</th>
				<th id = "theadLocation">LOCATION</th>
				<th id = "theadTimezone">TIMEZONE</th>
				<th id = "theadDST">DAYLIGHT SAVING TIME</th>
			</tr>
		</thead>
		<tbody>
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
		</tbody>
	</table>
</div>
</body>
</html>