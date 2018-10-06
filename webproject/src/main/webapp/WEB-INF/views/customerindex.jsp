<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@include file="contextpath.jsp"%>


<html>
<head>

<title>shoppy</title>

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

	<%@include file="defaultcustomerindex.jsp"%>
	<%@include file="carouselindex.jsp"%>

	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1>Shoppy</h1>
			<p>Shoppy is a leading online shopping mall.</p>
		</div>

	</div>
	<%@include file="footer.jsp"%>
</body>
</html>


