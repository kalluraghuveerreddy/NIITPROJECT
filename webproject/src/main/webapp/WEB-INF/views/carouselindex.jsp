<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/resources/images/" var="images"></spring:url>
<html>
<head>

</head>
<body>

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
				<img src="${contextPath}/resources/images/samsung j8.jpg" alt="samsung"
					width="100%" height="60%">
			</div>
			<div class="carousel-item">
				<img src="${contextPath}/resources/images/carousel3.png" alt="Redmi 4" width="100%"
					height="60%">
			</div>
			<div class="carousel-item">
				<img src="${contextPath}/resources/images/dell xps2.jpg" alt="Dell XPS"
					width="100%" height="60%">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="carousel-control-prev" href="#demo" data-slide="prev"> <span
			class="carousel-control-prev-icon"></span>
		</a> <a class="carousel-control-next" href="#demo" data-slide="next">
			<span class="carousel-control-next-icon"></span>
		</a>
	</div>
</body>
</html>