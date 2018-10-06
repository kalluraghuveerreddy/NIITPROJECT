<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@include file="contextpath.jsp"%>
<html>
<head>
<title>Edit vendor Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="registervendor.css">
</head>
<body>
	<%@include file="defaultvendorindex.jsp"%>
	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">
				<spring:form class="form-container"
					action="${contextPath}/vendor/editvendorprofileprocess"
					method="post" modelAttribute="vendor">
					<h2>Edit Vendor</h2>

					<div class="form-group">
						<spring:label path="vendor_id">Vendor ID</spring:label>
						<spring:input class="form-control" path="vendor_id" type="hidden"
							value="${vendorDetails.vendor_id }" />
					</div>
					<div class="form-group">
						<spring:label path="vendor_name">Name</spring:label>
						<spring:input type="text" class="form-control" path="vendor_name"
							value="${vendorDetails.vendor_name }" />
					</div>
					<div class="form-group">
						<spring:label path="vendor_email">Email</spring:label>
						<spring:input type="email" class="form-control"
							path="vendor_email" value="${vendorDetails.vendor_email }" />
					</div>

					<div class="form-group">
						<spring:label path="vendor_mobile">Mobile</spring:label>
						<spring:input type="phone" class="form-control"
							path="vendor_mobile" value="${vendorDetails.vendor_mobile }" />
					</div>
					<div class="form-group">
						<spring:label path="vendor_password">Password</spring:label>
						<spring:input type="hidden" class="form-control"
							path="vendor_password" value="${vendorDetails.vendor_password}" />
					</div>
					<div class="form-group">
						<spring:label path="company_name">Company Name</spring:label>
						<spring:input type="text" class="form-control" path="company_name"
							value="${vendorDetails.company_name }" />
					</div>

					<button type="submit" class="btn btn-primary btn-block">Update
						Vendor</button>
				</spring:form>
			</section>
		</section>
	</section>


</body>

</html>