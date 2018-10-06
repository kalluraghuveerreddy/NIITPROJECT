<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<%@include file="contextpath.jsp"%>
<html>
<head>
<title>Register Page</title>
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
	<%@include file="defaultcustomerindex.jsp"%>
	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">
				<springform:form class="form-container"
					action="${contextPath}/customer/editcustomerprofileprocess"
					method="post" modelAttribute="customer">
					<h2>Edit Customer</h2>

					<div class="form-group">
						<springform:label path="customer_id">Customer ID</springform:label>
						<springform:input type="hidden" class="form-control"
							path="customer_id" value="${customerDetails.customer_id}" />
					</div>

					<div class="form-group">
						<springform:label path="customer_name">Name</springform:label>
						<springform:input type="text" class="form-control"
							path="customer_name" value="${customerDetails.customer_name}" />
					</div>
					<div class="form-group">
						<springform:label path="customer_email">Email</springform:label>
						<springform:input type="email" class="form-control"
							path="customer_email" value="${customerDetails.customer_email}" />
					</div>

					<div class="form-group">
						<springform:label path="customer_mobile">Mobile</springform:label>
						<springform:input type="phone" class="form-control"
							path="customer_mobile" value="${customerDetails.customer_mobile}" />
					</div>
					<div class="form-group">
						<springform:label path="customer_password">Password</springform:label>
						<springform:input type="hidden" class="form-control"
							path="customer_password"
							value="${customerDetails.customer_password}" />
					</div>


					<button type="submit" class="btn btn-primary btn-block">Update
						Customer</button>
				</springform:form>
			</section>
		</section>
	</section>

</body>

</html>