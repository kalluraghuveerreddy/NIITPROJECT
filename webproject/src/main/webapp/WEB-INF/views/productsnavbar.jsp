
<html>
<head>
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
	<nav class="navbar navbar-expand-md bg navbar sticky-top">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle  text-danger" href="#"
					id="navbardrop" data-toggle="dropdown"> Electronics </a>
					<div class="dropdown-menu">
						<c:forEach items="${electronics}" var="electronic">
							<a class="dropdown-item"
								href="${contextPath}/products/${electronic.subCategory_id}">${electronic.subCategory_name}</a>
						</c:forEach>
					</div></li>


				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle text-danger" href="#"
					id="navbardrop" data-toggle="dropdown"> Men </a>
					<div class="dropdown-menu">
						<c:forEach items="${mens}" var="men">
							<a class="dropdown-item" href="${contextPath}/products/${men.subCategory_id}">${men.subCategory_name}</a>
						</c:forEach>
					</div></li>


				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle text-danger" href="#"
					id="navbardrop" data-toggle="dropdown"> Women </a>
					<div class="dropdown-menu">
						<c:forEach items="${womens}" var="women">
							<a class="dropdown-item" href="${contextPath}/products/${women.subCategory_id}">${women.subCategory_name}</a>
						</c:forEach>
					</div></li>


				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle text-danger" href="#"
					id="navbardrop" data-toggle="dropdown"> Home Appliances</a>
					<div class="dropdown-menu">
						<c:forEach items="${homeAppliances}" var="homeappliance">
							<a class="dropdown-item"
								href="${contextPath}/products/${homeappliance.subCategory_id}">${homeappliance.subCategory_name}</a>
						</c:forEach>
					</div></li>

			</ul>
		</div>
	</nav>
</body>
</html>

