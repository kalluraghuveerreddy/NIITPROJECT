<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri= "http://www.springframework.org/tags" prefix="spring"%>
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
<%@include file="defaultcustomerindex.jsp" %>
	<div style="flex: 2">
		<img alt="image" style="width: 500px"
			src='<spring:url value="/resources/images/products/${laptop.product_id }.jpg"></spring:url>'>
	</div>
	<table>
		<tr>
			<td>product_brand:</td>
			<td>${laptop.product_brand}</td>
		</tr>
		<tr>
			<td>laptopName:</td>
			<td>${laptop.laptopName }</td>
		</tr>
		<tr>
			<td>harddisk:</td>
			<td>${laptop.harddisk }</td>
		</tr>
		<tr>
			<td>ram:</td>
			<td>${laptop.ram}</td>
		</tr>
		<tr>
			<td>processor:</td>
			<td>${laptop.processor }</td>
		</tr>
		<tr>
			<td>product_price:</td>
			<td>${laptop.product_price }</td>
		</tr>
		
	</table>
	<div class="container" style="margin-top: 30px">
		<div class="row">

			<a href="${contextPath}/customer/addtocart"><button
					class="btn btn-danger">Buy</button></a>
		</div>
	</div>
</body>
</html>