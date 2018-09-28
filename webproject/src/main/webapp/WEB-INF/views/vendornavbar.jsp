<nav class="navbar navbar-expand-sm bg navbar justify-content-end ">

	<ul class="navbar-nav">


		<li class="nav-item"><a class="nav-link text-danger" href="#">Support</a>
		</li>

		<li class="nav-item"><a class="nav-link text-danger" href="#">Contact
				us</a></li>
	</ul>
	</nav>

	<nav class="navbar navbar-expand-sm bg navbar  sticky-top">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse " id="collapsibleNavbar">

		<ul class="navbar-nav">
			<li class="nav-item"><a class="navbar-brand  text-success"
				href="${contextPath}/index">Shoppy</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle  text-danger" href="#"
				id="navbardrop" data-toggle="dropdown"> Electronics </a>

				<div class="dropdown-menu">
					<c:forEach items="${electronics}" var="electronic">
						<a class="dropdown-item"
							href="products/${electronic.subCategory_id}">${electronic.subCategory_name}</a>
					</c:forEach>
				</div></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-danger" href="#"
				id="navbardrop" data-toggle="dropdown"> Men </a>
				<div class="dropdown-menu">
					<c:forEach items="${mens}" var="men">
						<a class="dropdown-item" href="products/${men.subCategory_id}">${men.subCategory_name}</a>
					</c:forEach>
				</div></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-danger" href="#"
				id="navbardrop" data-toggle="dropdown"> Women </a>
				<div class="dropdown-menu">
					<c:forEach items="${womens}" var="women">
						<a class="dropdown-item" href="products/${women.subCategory_id}">${women.subCategory_name}</a>
					</c:forEach>
				</div></li>


			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-danger" href="#"
				id="navbardrop" data-toggle="dropdown"> Home Appliances</a>
				<div class="dropdown-menu">
					<c:forEach items="${homeAppliances}" var="homeappliance">
						<a class="dropdown-item"
							href="products/${homeappliance.subCategory_id}">${homeappliance.subCategory_name}</a>
					</c:forEach>
				</div></li>

			<li class="nav-item"><a class="nav-link text-danger "
				href="customersignup">
					<form class="form-inline  " action="/action_page.php">
						<input class="form-control mr-sm-2  " type="text"
							placeholder="Search">
						<button class="btn btn-danger" type="submit">Search</button>
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
