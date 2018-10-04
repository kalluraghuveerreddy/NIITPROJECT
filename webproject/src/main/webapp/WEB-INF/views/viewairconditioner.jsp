<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
</head>
<body>
	<div style="flex: 2">
		<img alt="image" style="width: 500px"
			src='<spring:url value="/resources/images/products/${airconditioner.product_id }.jpg"></spring:url>'>
	</div>
	<table>
		<tr>
			<td>product_brand:</td>
			<td>${airconditioner.product_brand}</td>
		</tr>
		<tr>
			<td>Name:</td>
			<td>${airconditioner.name }</td>
		</tr>
		<tr>
			<td>Voltage:</td>
			<td>${airconditioner.voltage }</td>
		</tr>
		<tr>
			<td>Color:</td>
			<td>${airconditioner.color}</td>
		</tr>
		<form action="${contextPath }/customer/addtocart" method="get">
			<tr>
				<td>Enter number of products</td>
				<td><input type="number" name="noOfProducts"></td>
				<input type="hidden" name="productId"
					value="${airconditioner.product_id }">
			</tr>
			<tr>
				<td><input type="submit" value="Buy"></td>
			</tr>
		</form>
	</table>
</body>
</html>