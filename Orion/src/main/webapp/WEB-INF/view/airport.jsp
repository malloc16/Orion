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

<title>Airport</title>
</head>
<body>
	<h2>Welcome to Airport</h2>
	<c:if test="${not empty airports}">
	<div class="lista">
			<ul class="list-group">
			<c:forEach var="airport" items="${airports }">
				<!--  <li class="list-group-item">${airport}</li> <a href="${airport }" class="list-group-item">${airport }</a>-->
				<li class="list-group-item">
					<a href="${airport.url }">${airport.name }</a>
				</li>
			</c:forEach>
		</ul> 
		</div>
	</c:if>
	
</body>
</html>