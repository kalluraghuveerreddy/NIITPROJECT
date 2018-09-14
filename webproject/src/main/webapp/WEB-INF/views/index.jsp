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
		<li class="nav-item"><a class="nav-link text-danger"
			href="adminsignin">Admin</a></li>
		<li class="nav-item"><a class="nav-link text-danger" href="#">Support</a>
		</li>
		<li class="nav-item"><a class="nav-link text-danger" href="#">Contact
				us</a></li>

		<!-- Dropdown -->
		<li class="nav-item dropdown"><a
			class="nav-link dropdown-toggle text-danger" href="#" id="navbardrop"
			data-toggle="dropdown"> Sell on Shoppy </a>
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

	<nav class="navbar navbar-expand-sm bg-danger navbar-danger sticky-top">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse " id="collapsibleNavbar">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link text-white"
				href="#">Electronic</a></li>

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
						<img src="${images}carousal4.jpg" width="80%" height="80%">
					</div>
					<div class="carousel-item">
						<img src="${images}carousal5.jpg" width="80%" height="80%">
					</div>
					<div class="carousel-item">
						<img src="${images}carousal6.jpg" width="80%" height="80%">
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

	<br>

	<div class="container-fluid">
		<div class="row">
			<div class="col bg-success">Lorem ipsum dolor sit amet, cibo
				sensibus interesset no sit. Et dolor possim volutpat qui. No malis
				tollit iriure eam, et vel tale zril blandit, rebum vidisse nostrum
				qui eu. No nostrud dolorem legendos mea, ea eum mucius oporteat
				platonem.Eam an case scribentur, ei clita causae cum, alia debet eu
				vel.</div>
			<div class="col bg-warning">.col</div>
			<div class="col bg-success">.col</div>
		</div>
	</div>

	<br>
	<!-- Footer -->
	<footer class="page-footer font-small blue-grey lighten-5">

	<div style="background-color: #21d192;">
		<div class="container">

			<!-- Grid row-->
			<div class="row py-4 d-flex align-items-center">

				<!-- Grid column -->
				<div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
					<h6 class="mb-0">Get connected with us on social networks!</h6>
				</div>
				<!-- Grid column -->

				<!-- Grid column -->
				<div class="col-md-6 col-lg-7 text-center text-md-right">

					<!-- Facebook -->
					<a class="fb-ic"> <i class="fa fa-facebook white-text mr-4">
					</i>
					</a>
					<!-- Twitter -->
					<a class="tw-ic"> <i class="fa fa-twitter white-text mr-4">
					</i>
					</a>
					<!-- Google +-->
					<a class="gplus-ic"> <i
						class="fa fa-google-plus white-text mr-4"> </i>
					</a>
					<!--Linkedin -->
					<a class="li-ic"> <i class="fa fa-linkedin white-text mr-4">
					</i>
					</a>
					<!--Instagram-->
					<a class="ins-ic"> <i class="fa fa-instagram white-text"> </i>
					</a>

				</div>
				<!-- Grid column -->

			</div>
			<!-- Grid row-->

		</div>
	</div>

	<!-- Footer Links -->
	<div class="container text-center text-md-left mt-5">

		<!-- Grid row -->
		<div class="row mt-3 dark-grey-text">

			<!-- Grid column -->
			<div class="col-md-3 col-lg-4 col-xl-3 mb-4">

				<!-- Content -->
				<h6 class="text-uppercase font-weight-bold">Shoppy</h6>
				<hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto"
					style="width: 60px;">
				<p>Here you can use rows and columns here to organize your
					footer content. Lorem ipsum dolor sit amet, consectetur adipisicing
					elit.</p>

			</div>
			<!-- Grid column -->

			<!-- Grid column -->
			<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">

				<!-- Links -->
				<h6 class="text-uppercase font-weight-bold">Products</h6>
				<hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto"
					style="width: 60px;">
				<p>
					<a class="dark-grey-text" href="#!">MDBootstrap</a>
				</p>
				<p>
					<a class="dark-grey-text" href="#!">MDWordPress</a>
				</p>
				<p>
					<a class="dark-grey-text" href="#!">BrandFlow</a>
				</p>
				<p>
					<a class="dark-grey-text" href="#!">Bootstrap Angular</a>
				</p>

			</div>
			<!-- Grid column -->

			<!-- Grid column -->
			<div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">

				<!-- Links -->
				<h6 class="text-uppercase font-weight-bold">Useful links</h6>
				<hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto"
					style="width: 60px;">
				<p>
					<a class="dark-grey-text" href="#!">Your Account</a>
				</p>
				<p>
					<a class="dark-grey-text" href="#!">Become an Affiliate</a>
				</p>
				<p>
					<a class="dark-grey-text" href="#!">Shipping Rates</a>
				</p>
				<p>
					<a class="dark-grey-text" href="#!">Help</a>
				</p>

			</div>
			<!-- Grid column -->

			<!-- Grid column -->
			<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

				<!-- Links -->
				<h6 class="text-uppercase font-weight-bold">Contact</h6>
				<hr class="teal accent-3 mb-4 mt-0 d-inline-block mx-auto"
					style="width: 60px;">
				<p>
					<i class="fa fa-home mr-3"></i> New York, NY 10012, US
				</p>
				<p>
					<i class="fa fa-envelope mr-3"></i> info@shoppy.com
				</p>
				<p>
					<i class="fa fa-phone mr-3"></i> + 01 234 567 88
				</p>
				<p>
					<i class="fa fa-print mr-3"></i> + 01 234 567 89
				</p>

			</div>
			<!-- Grid column -->

		</div>
		<!-- Grid row -->

	</div>
	<!-- Footer Links --> <!-- Copyright -->
	<div class="footer-copyright text-center text-black-50 py-3">
		© 2018 Copyright: <a class="dark-grey-text"
			href="https://mdbootstrap.com/bootstrap-tutorial/"> Shoppy.com</a>
	</div>
	<!-- Copyright --> </footer>
	<!-- Footer -->

</body>
</html>


