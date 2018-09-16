<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set value="${pageContext.request.contextPath}" var="contextPath"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
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

	<%-- <div class="container">
		<div class="row">
			<c:forEach items="${productList}" var="product">
				<div class="col-md-4">
					<div class="thumbnail">
						<img
							src="<spring:url  value="/resources/images/products/${product.product_id}.jpg"></spring:url>"
							alt="${product.product_brand }" style="width: 100%" />

						<div class="caption">
							<h3>${product.product_brand}</h3>
							<a
								href="${contextPath}/viewproductspecifications/${product.product_id }"><button
									class="btn btn-primary">view</button></a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div> --%>


		<div class="container" style="margin-top: 50px">
			<div class="row">

				<c:forEach items="${products }" var="product">

					<div class="card" style="width: 12rem">
						<img class="card-img-top"
							src='<spring:url value="/resources/images/products/${product.productId }.jpg"></spring:url>'
							alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title">${product.product_brand }
								${product.product_model } ${product.product_color }</h5>
							<a href="productdetails/${product.productId }"><button
									class="btn btn-info">view</button></a><%--  <a
								href="editmobiledetails/${product.productId }"><button
									class="btn btn-warning">edit</button></a> --%>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
</body>
</html>