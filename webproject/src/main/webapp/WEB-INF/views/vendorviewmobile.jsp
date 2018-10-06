<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@include file="contextpath.jsp"%>

<html>
<head>

<title>Products</title>

<style type="text/css">
.body {
	display: flex;
}

.body table {
	margin: 50px;
}

.body .row {
	padding: 20px;
}
</style>

</head>
<body>

	<%@include file="defaultvendorindex.jsp"%>
	
	<div class="body">
		<div style="flex: 2">
			<img alt="image" style="width: 250px"
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
				<tr>
					<td>ram:</td>
					<td>${mobile.ram}</td>
				</tr>
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
		<div class="container" style="margin: 30px">
			<div class="row">

				<a
					href="${contextPath}/vendor/editproductspecifications/${mobile.product_id }"><button
						class="btn btn-danger">Edit</button></a>
			</div>
		</div>
	</div>
</body>
</html>