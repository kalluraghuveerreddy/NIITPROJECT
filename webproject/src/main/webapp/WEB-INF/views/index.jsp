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

	<nav
		class="navbar navbar-expand-sm bg navbar justify-content-end ">

	<!-- Links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link text-danger"
			href="adminsignin">Admin</a></li>
		<li class="nav-item"><a class="nav-link text-danger" href="#">Support</a>
		</li>
		<li class="nav-item"><a class="nav-link text-danger" href="#">Contact
				us</a></li>

		<!-- Dropdown -->
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			href="#" id="navbardrop" data-toggle="dropdown"> Sell on Shoppy </a>
			<div class="dropdown-menu">
				<a class="dropdown-item  text-danger" href="vendorsignup">Sign
					up</a> <a class="dropdown-item text-danger" href="vendorsignin">Sign
					in</a>
			</div></li>
	</ul>
	</nav>



	<nav class="navbar navbar-expand-md bg  navbar "> <a
		class="navbar-brand  text-danger" href="#">Shoppy</a>

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse justify-content-end"
		id="collapsibleNavbar">

		<ul class="navbar-nav ">

			<li class="nav-item"><a class="nav-link text-danger"
				href="customersignup">Register</a></li>
			<li class="nav-item"><a class="nav-link text-danger"
				href="customersignin">Login</a></li>
			<li class="nav-item"><a class="nav-link text-danger" href="#">Cart</a></li>
		</ul>
	</div>
	</nav>

	<nav class="navbar navbar-expand-sm bg-danger navbar-danger ">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse " id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link text-white"
				href="#">Electronic</a></li>
			<li class="nav-item"><a class="nav-link text-white" href="#">Tv
					& Applinaces</a></li>
			<li class="nav-item"><a class="nav-link text-white" href="#">Men</a>
			</li>
			<li class="nav-item"><a class="nav-link text-white" href="#">Women</a>
			</li>
			<li class="nav-item"><a class="nav-link text-white" href="#">Baby
					& Kids</a></li>
			<li class="nav-item"><a class="nav-link text-white" href="#">Home
					& Furniture</a></li>
			<li class="nav-item"><a class="nav-link text-white" href="#">Sprots
					& Books,More</a></li>

			<form class="form-inline" action="">
				<input class="form-control mr-sm" type="text" placeholder="Search">
				<button class="btn btn-danger  text-white" type="submit">Search</button>
			</form>
		</ul>
	</div>
	</nav>
	<br>

	<div class="row">
		<div class="col-1"></div>
		<div class="col-10">

			<div id="demo" class="carousel slide" data-ride="carousel">

				<!-- Indicators -->
				<ul class="carousel-indicators">
					<li data-target="#demo" data-slide-to="0" class="active"></li>
					<li data-target="#demo" data-slide-to="1"></li>
					<li data-target="#demo" data-slide-to="2"></li>
				</ul>

				<!-- The slideshow -->
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="${images}carousal4.jpg">
					</div>
					<div class="carousel-item">
						<img src="${images}carousal5.jpg">
					</div>
					<div class="carousel-item">
						<img src="${images}carousal6.jpg">
					</div>
				</div>

				<!-- Left and right controls -->

				<a class="carousel-control-prev" href="#demo" data-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</a> <a class="carousel-control-next" href="#demo" data-slide="next">
					<span class="carousel-control-next-icon"></span>
				</a>
			</div>
		</div>
		<div class="col-1"></div>
	</div>

</body>
</html>


