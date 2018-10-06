<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="contextpath.jsp"%>

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
<body>

	<%@include file="defaultcustomerindex.jsp"%>
	<h2 class="text-danger ">cart</h2>
	<br>
	<table class="table">
		<thead>
			<tr>
				<th>Brand</th>
				<th>Name</th>
				<th>Unit Price</th>
				<th>Quantity</th>
				<th>Total Price</th>


			</tr>
		</thead>
		<tbody>
			<c:forEach items="${cart.cartItems}" var="cartItem">
				<tr>
					<td>${cartItem.cartItemIds[0].noOfProducts.product.product_brand}</td>
					<td>${cartItem.cartItemIds[0].noOfProducts.product.product_name}</td>
					<td>${cartItem.cartItemIds[0].noOfProducts.product.product_price}</td>
						<td>${cartItem.quantity}</td>
					<td>${cartItem.cartItemIds[0].noOfProducts.product.product_price * cartItem.quantity}</td>
					<td><a href="${contextPath}/customer/${cartItem.cartItem_id}"><input
							type="button" value="Delete"></a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div>
		<table>
			<td>Number of items:</td>
			<td>${cart.noOfItems}</td>
		</table>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>