<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri= "http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
			<form action="${contextPath }/customer/addtocart" method="get">
				<tr>
					<td>Enter number of products</td>
					<td><input type="number" name="noOfProducts"></td>
					<input type="hidden" name="productId" value="${mobile.product_id }">
				</tr>
				<tr>
					<td><input type="submit" value="Buy"></td>
				</tr>
			</form>
		</tbody>
	</table>
</body>
</html>