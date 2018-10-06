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
	margin: 30px;
}

.body .form {
	margin: 20px;
}
</style>

</head>
<body>
	<%@include file="defaultcustomerindex.jsp"%>
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

		<form action="${contextPath }/customer/addtocart" method="get">
			<table>
				<tbody>
					<tr>
						<td>Product Id</td>
						<td><input type="hidden" name="product_id"
							value="${mobile.product_id }" /></td>
					</tr>
					<tr>
						<td>Enter number of products</td>
						<td><input type="number" name="noOfProducts"></td>
					</tr>

					<tr>
						<td><input type="submit" value="Buy now"></td>
					</tr>
				</tbody>
			</table>
		</form>

	</div>
	<%@include file="footer.jsp"%>
</body>
</html>