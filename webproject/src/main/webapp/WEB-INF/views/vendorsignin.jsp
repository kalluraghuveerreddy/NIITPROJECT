<!DOCTYPE html>
<html>
<head>
<title>vendor Login Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="loginvendor.css">

</head>
<body>
	<nav class="navbar navbar-expand-sm bg navbar justify-content-end ">

		<!-- Links -->
		<ul class="navbar-nav">
			<!-- Dropdown -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-danger" href="#"
				id="navbardrop" data-toggle="dropdown"> Sell on Shoppy </a>
				<div class="dropdown-menu">
					<a class="dropdown-item  text-danger" href="vendorsignup">Sign
						up</a> <a class="dropdown-item text-danger" href="vendorsignin">Sign
						in</a>
				</div></li>
			<li class="nav-item"><a class="nav-link text-danger"
				href="adminsignin">Admin</a></li>
			<li class="nav-item"><a class="nav-link text-danger" href="#">Support</a>
			</li>
			<li class="nav-item"><a class="nav-link text-danger" href="#">Contact
					us</a></li>
		</ul>
	</nav>

	<nav class="navbar navbar-expand-md bg-light  navbar-light ">
		<a class="navbar-brand  text-danger" href="#">Shoppy</a>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse justify-content-end"
			id="collapsibleNavbar">

			<ul class="navbar-nav ">
				<li class="nav-item"><a class="nav-link text-danger "
					href="customersignup">
						<form class="form-inline  " action="/action_page.php">
							<input class="form-control mr-sm-2  " type="text"
								placeholder="Search">
							<button class="btn btn-success" type="submit">Search</button>
						</form>
				</a></li>
			</ul>
			<ul class="navbar-nav ">

				<li class="nav-item"><a class="nav-link text-danger"
					href="customersignup">Sign up</a></li>
				<li class="nav-item"><a class="nav-link text-danger"
					href="customersignin">Sign in</a></li>

			</ul>
		</div>
	</nav>
	<%@include file="navbar.jsp"%>
	
	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">
				<form class="form-container" action="vendorloginprocess"
					method="post">
					<h2>Login</h2>
					<div class="form-group">
						<label for="vendor_email">Email address</label> <input
							type="email" class="form-control" id="vendor_email"
							name="vendor_email" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label for="vendor_password">Password</label> <input
							type="password" class="form-control" id="vendor_password"
							name="vendor_password" placeholder="Enter Password">
					</div>

					<button type="submit" class="btn btn-primary btn-block">Login</button>
				</form>
			</section>
		</section>
	</section>

	<br>
	<%@include file="homecarousel.jsp"%>

	<br>
	<%@include file="footer.jsp"%>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>

</body>

</html>