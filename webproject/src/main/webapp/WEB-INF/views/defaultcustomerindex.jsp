<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
	<nav class="navbar navbar-expand-sm bg navbar  "> <a
		class="navbar-brand" href="${contextPath}/customer/customerindex">Shoppy</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse  justify-content-end"
		id="collapsibleNavbar">
		<marquee> <h6>Welocme ${customerDetails.customer_name}</h6></marquee>
		<ul class="navbar-nav">

			<li class="nav-item"><a class="nav-link text-danger"
				href="${contextPath}/customer/support">Support</a></li>

			<li class="nav-item"><a class="nav-link text-danger"
				href="${contextPath}/customer/contact">Contact </a></li>


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
				href="${contextPath}/customer/customerindex">Home</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle  text-white" href="#"
				id="navbardrop" data-toggle="dropdown"> Electronics </a>
				<div class="dropdown-menu">
					<c:forEach items="${electronics}" var="electronic">
						<a class="dropdown-item"
							href="${contextPath}/customerproducts/${electronic.subCategory_id}">${electronic.subCategory_name}</a>
					</c:forEach>
				</div></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Men </a>
				<div class="dropdown-menu">
					<c:forEach items="${mens}" var="men">
						<a class="dropdown-item"
							href="${contextPath}/customerproducts/${men.subCategory_id}">${men.subCategory_name}</a>
					</c:forEach>
				</div></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Women </a>
				<div class="dropdown-menu">
					<c:forEach items="${womens}" var="women">
						<a class="dropdown-item"
							href="${contextPath}/customerproducts/${women.subCategory_id}">${women.subCategory_name}</a>
					</c:forEach>
				</div></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Home Appliances</a>
				<div class="dropdown-menu">
					<c:forEach items="${homeAppliances}" var="homeappliance">
						<a class="dropdown-item"
							href="${contextPath}/customerproducts/${homeappliance.subCategory_id}">${homeappliance.subCategory_name}</a>
					</c:forEach>
				</div></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> My Account</a>
				<div class="dropdown-menu">
					<a class="dropdown-item"
						href="${contextPath}/customer/customerprofile">My profile</a> <a
						class="dropdown-item"
						href="${contextPath}/customer/editcustomerprofile"> Edit
						profile</a> <a class="dropdown-item" href="#"> My orders</a> <a
						class="dropdown-item" href="customer/logout">Logout</a>
				</div></li>
			<li class="nav-item"><a class="nav-link text-white" href="${contextPath}/customer/cart">cart</a></li>

		</ul>
	</div>
	</nav>

</body>
</html>