<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@include file="contextpath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<%@include file="defaultcustomerindex.jsp"%>
	<springform:form>
		<table>


			<tr>
				<td>Name:</td>
				<td>${customerDetails.customer_name}</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td>${customerDetails.customer_mobile}</td>

			</tr>

			<tr>
				<td>Mobile:</td>
				<td>${customerDetails.customer_email}</td>

			</tr>

			<tr>
				<td>Status:</td>
				<td>${customerDetails.status}</td>

			</tr>

		</table>


	</springform:form>
	<%@include file="footer.jsp"%>
</body>
</html>