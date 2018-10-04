<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<html>
<head>
<title>Register Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="registercustomer.css">
</head>
<body>

	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">
				<spring:form class="form-container" action="customer/editcustomerprofileprocess"
					method="post" modelAttribute="customer">
					<h2>Edit Customer</h2>
					
					<div class="form-group">
						<spring:label path="customer_id">Customer ID</spring:label>
						<spring:input type="hidden" class="form-control"
							path="customer_id" value="${customerDetails.customer_id}" />
					</div>
					
					<div class="form-group">
						<spring:label path="customer_name">Name</spring:label>
						<spring:input type="text" class="form-control"
							path="customer_name" value="${customerDetails.customer_name}" />
					</div>
					<div class="form-group">
						<spring:label path="customer_email">Email</spring:label>
						<spring:input type="email" class="form-control"
							path="customer_email" value="${customerDetails.customer_email}"  />
					</div>

					<div class="form-group">
						<spring:label path="customer_mobile">Mobile</spring:label>
						<spring:input type="phone" class="form-control"
							path="customer_mobile" value="${customerDetails.customer_mobile}"  />
					</div>
					<div class="form-group">
						<spring:label path="customer_password">Password</spring:label>
						<spring:input type="hidden" class="form-control"
							path="customer_password"  value="${customerDetails.customer_password}"  />
					</div>


					<button type="submit" class="btn btn-primary btn-block">Update Customer</button>
				</spring:form>
			</section>
		</section>
	</section>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>

</body>

</html>