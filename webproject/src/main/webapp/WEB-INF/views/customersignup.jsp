<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@include file="contextpath.jsp"%>
<html>
<head>
<title>Customer Register Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="registercustomer.css">
</head>
<body>

	<%@include file="defaultindex.jsp"%>

	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">
				<spring:form class="form-container" action="customerregisterprocess"
					method="post" modelAttribute="customer">
					<h2>Register</h2>
					<div class="form-group">
						<spring:label path="customer_name">Name</spring:label>
						<spring:input type="text" class="form-control"
							path="customer_name" placeholder="Enter  name" />

					</div>
					<div class="form-group">
						<spring:label path="customer_email">Email</spring:label>
						<spring:input type="email" class="form-control"
							path="customer_email" placeholder="Enter email" />

					</div>

					<div class="form-group">
						<spring:label path="customer_mobile">Mobile</spring:label>
						<spring:input type="phone" class="form-control"
							path="customer_mobile" placeholder="Enter mobile number" />

					</div>
					<div class="form-group">
						<spring:label path="customer_password">Password</spring:label>
						<spring:input type="password" class="form-control"
							path="customer_password" placeholder="Enter Password" />

					</div>
					<button type="submit" class="btn btn-primary btn-block">Register</button>
						<h5>already have a account? <a  class="text-danger" href="${contextPath}/customersignin">Sign in</a></h5>
				</spring:form>
			</section>
		</section>
	</section>


	<%@include file="footer.jsp"%>
</body>


</html>