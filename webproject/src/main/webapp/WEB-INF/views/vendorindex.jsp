<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/resources/images/" var="images"></spring:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
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


	<nav class="navbar navbar-expand-sm bg navbar justify-content-end ">

	<!-- Links -->
	<ul class="navbar-nav">

		<li class="nav-item"><a class="nav-link text-danger" href="#">Support</a>
		</li>
		<li class="nav-item"><a class="nav-link text-danger" href="#">Contact
				us</a></li>
	</ul>
	</nav>

	<nav class="navbar navbar-expand-md bg  navbar"> <a
		class="navbar-brand  text-danger" href="#">Shoppy</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse  justify-content-end"
		id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link text-danger "
				href="customersignup">
					<form class="form-inline  " action="/action_page.php">
						<input class="form-control mr-sm-2  " type="text"
							placeholder="Search">
						<button class="btn btn-success" type="submit">Search</button>
					</form>
			</a></li>
			<!-- Dropdown -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-danger" href="#"
				id="navbardrop" data-toggle="dropdown"> Products </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="categories"> Add Product</a> <a
						class="dropdown-item" href="productdetails">View Products</a>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-danger" href="#"
				id="navbardrop" data-toggle="dropdown"> My Account</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="vendorprofile">My profile</a> <a
						class="dropdown-item" href="editvendorprofile"> Edit Profile</a>

				</div></li>

		</ul>
	</div>
	</nav>

	<%@include file="navbar.jsp"%>

</body>
</html>