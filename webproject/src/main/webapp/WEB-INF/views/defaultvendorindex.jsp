<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>defaultindex</title>
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
		class="navbar-brand" href="${contextPath}/vendor/vendorindex">Shoppy</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse  justify-content-end"
		id="collapsibleNavbar">
		<marquee>
			<h6>Welocme ${vendorDetails.vendor_name}</h6>
		</marquee>
		<ul class="navbar-nav">

			<li class="nav-item"><a class="nav-link text-danger"
				href="${contextPath}/vendor/support">Support</a></li>

			<li class="nav-item"><a class="nav-link text-danger"
				href="${contextPath}/vendor/contact">Contact</a></li>

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
			<li class="nav-item"><a class="nav-link text-white"
				href="${contextPath}/vendor/vendorindex">Home</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle  text-white" href="#"
				id="navbardrop" data-toggle="dropdown"> Electronics </a>
				<div class="dropdown-menu">
					<c:forEach items="${electronics}" var="electronic">
						<a class="dropdown-item"
							href="${contextPath}/vendorproducts/${electronic.subCategory_id}">${electronic.subCategory_name}</a>
					</c:forEach>
				</div></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Men </a>
				<div class="dropdown-menu">
					<c:forEach items="${mens}" var="men">
						<a class="dropdown-item"
							href="${contextPath}/vendorproducts/${men.subCategory_id}">${men.subCategory_name}</a>
					</c:forEach>
				</div></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Women </a>
				<div class="dropdown-menu">
					<c:forEach items="${womens}" var="women">
						<a class="dropdown-item"
							href="${contextPath}/vendorproducts/${women.subCategory_id}">${women.subCategory_name}</a>
					</c:forEach>
				</div></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Home Appliances</a>
				<div class="dropdown-menu">
					<c:forEach items="${homeAppliances}" var="homeappliance">
						<a class="dropdown-item"
							href="${contextPath}/vendorproducts/${homeappliance.subCategory_id}">${homeappliance.subCategory_name}</a>
					</c:forEach>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Products </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${contextPath}/vendor/categories">
						Add Product</a> <a class="dropdown-item"
						href="${contextPath}/vendor/productdetails">View Products</a>
				</div></li>

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> My Account</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="${contextPath}/vendor/vendorprofile">My
						profile</a> <a class="dropdown-item"
						href="${contextPath}/vendor/editvendorprofile"> Edit Profile</a> <a
						class="dropdown-item" href="vendor/logout"> Logout</a>
				</div></li>


		</ul>
	</div>
	</nav>
</body>
</html>