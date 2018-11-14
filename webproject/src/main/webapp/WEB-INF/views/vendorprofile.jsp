<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@include file="contextpath.jsp"%>
<html>
<head>
<title>Edit vendor Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="registervendor.css">
</head>
<body>
	<%@include file="defaultvendorindex.jsp"%>
	<spring:form>
		<table>

			<tr>
				<td>Name:</td>
				<td>${vendorDetails.vendor_name}</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${vendorDetails.vendor_mobile}</td>

			</tr>

			<tr>
				<td>Mobile:</td>
				<td>${vendorDetails.vendor_email}</td>

			</tr>

			<tr>
				<td>Company Name:</td>
				<td>${vendorDetails.company_name}</td>

			</tr>

			<tr>
				<td>role:</td>
				<td>${vendorDetails.status}</td>

			</tr>


		</table>


	</spring:form>
	<%@include file="footer.jsp"%>
</body>
</html>