<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value='/static/css/bootstrap.css' />"
	rel="stylesheet" />
<link href="<c:url value='/static/css/custom.css' />" rel="stylesheet" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script>
	$(function() {
		$("#departureDate").datepicker({
			dateFormat : 'yy-mm-dd'
		});//tu se postavi id od polja za koje treba prikazati datepicker
	});
	$(function() {
		$("#returnDate").datepicker({
			dateFormat : 'yy-mm-dd'
		});
	});
	$(function() {
		$("#arriveByDate").datepicker({
			dateFormat : 'yy-mm-dd'
		});
	});
	$(function() {
		$("#returnByDate").datepicker({
			dateFormat : 'yy-mm-dd'
		});
	});
</script>
<title>Flights</title>

</head>
<body>

	<input type="button" onclick="location = '/Orion'" value="Povratak">
	<h2>Welcome to Flights Search</h2>
	<br />
	<div class="form-container">
	<!--  -->
		<form:form method="post" modelAttribute="search" class="form-horizontal">
		 <!-- -->
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="origin">Origin</label>
				<div class = "col-md-7">
					<form:input path="origin" id="origin" type="text" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="origin" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">	
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="destination">Destination</label>
				<div class="col-md-7">
					<form:input type="text" path="destination" id="destination"
						class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="destination" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="departureDate">Departure
					Date</label>
				<div class="col-md-7">
					<form:input type="text" path="departureDate" id="departureDate" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="departureDate" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="returnDate">Return Date</label>
				<div class="col-md-7">
					<form:input type="text" path="returnDate" id="returnDate" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="returnDate" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="arriveByDate">Arrive By Date</label>
				<div class="col-md-7">
					<form:input type="text" path="arriveByDate" id="arriveByDate" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="arriveByDate" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="returnByDate">Return By Date</label>
				<div class="col-md-7">
					<form:input type="text" path="returnByDate" id="returnByDate" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="returnByDate" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="adultsNumber">Adults</label>
				<div class="col-md-7">
					<form:input type="text" path="adultsNumber" id="adultsNumber" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="adultsNumber" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="childrenNumber">Children</label>
				<div class="col-md-7">
					<form:input type="text" path="childrenNumber" id="childrenNumber" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="childrenNumber" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="infantsNumber">Infants</label>
				<div class="col-md-7">
					<form:input type="text" path="infantsNumber" id="infantsNumber" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="infantsNumber" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="includeAirlines">Include Airlines</label>
				<div class="col-md-7">
					<form:input type="text" path="includeAirlines" id="includeAirlines" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="includeAirlines" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="excludeAirlines">Exclude Airlines</label>
				<div class="col-md-7">
					<form:input type="text" path="excludeAirlines" id="excludeAirlines" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="excludeAirlines" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="nonStop">Non Stop</label>
				<div class="col-md-1">
					<form:checkbox path="nonStop" id="nonStop" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="nonStop" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="maxPrice">Max Price</label>
				<div class="col-md-7">
					<form:input type="text" path="maxPrice" id="maxPrice" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="maxPrice" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="currency">Currency</label>
				<div class="col-md-7">
					<form:input type="text" path="currency" id="currency" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="currency" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="travelClass">Travel Class</label>
				<div class="col-md-7">
					<form:input type="text" path="travelClass" id="travelClass" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="travelClass" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-lable" for="numberOfResults">Max Number Of Results</label>
				<div class="col-md-7">
					<form:input type="text" path="numberOfResults" id="numberOfResults" class="form-control input-sm" />
					<div class="has-error">
						<form:errors path="numberOfResults" class="help-inline" />
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="form-actions floatRight">
				<input type="submit" value="Send" class="btn btn-primary btn-sm">
			</div>
		</div>
		</form:form>
	</div>
</body>
</html>