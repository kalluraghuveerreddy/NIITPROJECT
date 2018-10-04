<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@include file="contextpath.jsp"%>

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
			src='<spring:url value="/resources/images/products/${mobile.product_id }.jpg"></spring:url>'>
	</div>
	<table>
		<tbody>

			<tr>
				<td>product_brand:</td>
				<td>${mobile.product_brand}</td>
			</tr>
			<tr>
				<td>name:</td>
				<td>${mobile.name }</td>
			</tr>
			<tr>
				<td>memory:</td>
				<td>${mobile.memory }</td>
			</tr>
			<td>ram:</td>
			<td>${mobile.ram}</td>
			<tr>
				<td>screen size:</td>
				<td>${mobile.screenSize }</td>
			</tr>
			<tr>
				<td>product_price:</td>
				<td>${mobile.product_price }</td>
			</tr>


		</tbody>
	</table>
	<div class="container" style="margin-top: 30px">
		<div class="row">

			<a href="${contextPath}/customer/addtocart"><button
					class="btn btn-danger">Buy</button></a>
		</div>
	</div>
</body>
</html>