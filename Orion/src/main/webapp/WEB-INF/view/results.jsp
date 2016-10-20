<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
<title>Orion - Results</title>
</head>
<body>
	<h2>Results</h2>
	<input type="button" value="Idi na letove"
		onclick="location = '/Orion/Flights/'" />
	<br /> Origin: ${search.origin}
	<br /> Destination: ${search.destination}
	<br /> Departure Date: ${search.departureDate}
	<br />
</body>
</html>