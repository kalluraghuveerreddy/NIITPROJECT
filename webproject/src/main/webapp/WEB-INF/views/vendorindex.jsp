<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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

	<nav class="navbar navbar-expand-md bg-primary navbar-primary"> <a
		class="navbar-brand text-warning" href="#">Shoppy</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	 <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      Dropdown button
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">Link 1</a>
      <a class="dropdown-item" href="#">Link 2</a>
      <a class="dropdown-item" href="#">Link 3</a>
    </div>
  </div>
   <div class="dropdown">
    <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
      Dropdown button
    </button>
    <div class="dropdown-menu">
      <a class="dropdown-item" href="#">Link 1</a>
      <a class="dropdown-item" href="#">Link 2</a>
      <a class="dropdown-item" href="#">Link 3</a>
    </div>
  </div>
	</nav>

	<nav class="navbar navbar-expand-sm bg-light navbar-light">
	<ul class="navbar-nav">
		<li class="nav-item active"><a class="nav-link text-body"
			href="#">Electronic</a></li>
		<li class="nav-item"><a class="nav-link text-body" href="#">Tv
				& Applinaces</a></li>
		<li class="nav-item"><a class="nav-link text-body" href="#">Men</a>
		</li>
		<li class="nav-item"><a class="nav-link text-body" href="#">Women</a>
		</li>
		<li class="nav-item"><a class="nav-link text-body" href="#">Baby
				& Kids</a></li>
		<li class="nav-item"><a class="nav-link text-body" href="#">Home
				& Furniture</a></li>
		<li class="nav-item"><a class="nav-link text-body" href="#">Sprots
				& Books,More</a></li>
	</ul>
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
						<img src="carousal4.jpg" alt="Los Angeles" width="1100"
							height="500">
					</div>
					<div class="carousel-item">
						<img src="carousal5.jpg" alt="Chicago" width="1100" height="500">
					</div>
					<div class="carousel-item">
						<img src="carousal6.jpg" alt="New York" width="1100" height="500">
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