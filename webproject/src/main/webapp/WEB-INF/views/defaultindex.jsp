<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<nav class="navbar navbar-expand-sm bg navbar  "> <a
		class="navbar-brand" href="${contextPath}/index">Shoppy</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse  justify-content-end"
		id="collapsibleNavbar">
		<marquee>Welocme to Shoppy </marquee>
		<ul class="navbar-nav">
             
			<li class="nav-item"><a class="nav-link text-danger"
				href="support">Support</a></li>

			<li class="nav-item"><a class="nav-link text-danger"
				href="contact">Contact </a></li>
			<li class="nav-item"><a class="nav-link text-danger"
				href="adminsignin">admin</a></li>

		</ul>
	</nav>

	<nav class="navbar navbar-expand-md bg-info navbar-info sticky-top ">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse justify-content-end"
		id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link text-white" href="${contextPath}/index">Home</a></li>
			
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle  text-white" href="#"
				id="navbardrop" data-toggle="dropdown"> Electronics </a>
				<div class="dropdown-menu">
					<c:forEach items="${electronics}" var="electronic">
						<a class="dropdown-item"
							href="${contextPath}/products/${electronic.subCategory_id}">${electronic.subCategory_name}</a>
					</c:forEach>
				</div></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Men </a>
				<div class="dropdown-menu">
					<c:forEach items="${mens}" var="men">
						<a class="dropdown-item"
							href="${contextPath}/products/${men.subCategory_id}">${men.subCategory_name}</a>
					</c:forEach>
				</div></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Women </a>
				<div class="dropdown-menu">
					<c:forEach items="${womens}" var="women">
						<a class="dropdown-item"
							href="${contextPath}/products/${women.subCategory_id}">${women.subCategory_name}</a>
					</c:forEach>
				</div></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Home Appliances</a>
				<div class="dropdown-menu">
					<c:forEach items="${homeAppliances}" var="homeappliance">
						<a class="dropdown-item"
							href="${contextPath}/products/${homeappliance.subCategory_id}">${homeappliance.subCategory_name}</a>
					</c:forEach>
				</div></li>

			<li class="nav-item"><a class="nav-link text-white"
				href="${contextPath}/customersignup">Sign up</a></li>
			<li class="nav-item"><a class="nav-link text-white"
				href="${contextPath}/customersignin">Sign in</a></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle  text-white" href="#"
				id="navbardrop" data-toggle="dropdown"> Sell on Shoppy </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${contextPath}/vendorsignup">Sign up</a> <a
						class="dropdown-item" href="${contextPath}/vendorsignin">Sign in</a>

				</div></li>

		</ul>
	</div>
	</nav>

</body>
</html>