<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="contextpath.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>categories</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script> -->
</head>
<body>
	<%@include file="defaultvendorindex.jsp"%>

	<li class="nav-item dropdown"><a
		class="nav-link dropdown-toggle text-danger" href="#" id="navbardrop"
		data-toggle="dropdown">Categories</a>
		<div class="dropdown-menu">
			<c:forEach items="${categoryList}" var="category">
				<a class="dropdown-item" href="${contextPath}/vendor/subcategory/${category.category_id}">${category.category_name}</a>
			</c:forEach>
		</div></li>



</body>
</html>
