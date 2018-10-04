<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri= "http://www.springframework.org/tags" prefix="spring"%>
<%@include file="contextpath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="defaultcustomerindex.jsp" %>
	
	<div style="flex: 2">
		<img alt="image" style="width: 500px"
			src='<spring:url value="/resources/images/products/${kurta.product_id }.jpg"></spring:url>'>
	</div>
	<table>
		
		<tr>
			<td>Product Brand:</td>
			<td>${kurta.product_brand }</td>
		</tr>
		<tr>
			<td>Name:</td>
			<td>${kurta.name }</td>
		</tr>
	
		<tr>
		<td>Color:</td>
		<td>${kurta.color}</td>
		</tr>
		<tr>
		<td>Size::</td>
		<td>${kurta.size}</td>
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