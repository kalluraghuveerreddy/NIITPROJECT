<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@include file ="contextpath.jsp" %>
<html>
<head>
<title>Register Page</title>
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

<%@include file="defaultindex.jsp" %>

	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">
				<spring:form class="form-container" action="vendorregisterprocess"
					method="post" modelAttribute="vendor">
					<h2>Register</h2>
					<div class="form-group">
						<spring:label path="vendor_name">Name</spring:label>
						<spring:input type="text" class="form-control" path="vendor_name"
							placeholder="Enter  name" />
							<span style="color:red"><spring:errors path="vendor_name" ></spring:errors></span>
					</div>
					<div class="form-group">
						<spring:label path="vendor_email">Email</spring:label>
						<spring:input type="email" class="form-control"
							path="vendor_email" placeholder="Enter email" />
							<span style="color:red"><spring:errors path="vendor_email" ></spring:errors></span>
					</div>

					<div class="form-group">
						<spring:label path="vendor_mobile">Mobile</spring:label>
						<spring:input type="phone" class="form-control"
							path="vendor_mobile" placeholder="Enter mobile number" />
							<span style="color:red"><spring:errors path="vendor_mobile" ></spring:errors></span>
					</div>
					<div class="form-group">
						<spring:label path="vendor_password">Password</spring:label>
						<spring:input type="password" class="form-control"
							path="vendor_password" placeholder="Enter Password" />
							<span style="color:red"><spring:errors path="vendor_password" ></spring:errors></span>
					</div>
					<div class="form-group">
						<spring:label path="company_name">Company Name</spring:label>
						<spring:input type="text" class="form-control" path="company_name"
							placeholder="Enter compnay name" />
							<span style="color:red"><spring:errors path="company_name" ></spring:errors></span>
					</div>

					<button type="submit" class="btn btn-primary btn-block">Register</button>
					<h5>already have a account? <a  class="text-danger" href="${contextPath}/vendorsignin">Sign in</a></h5>
				</spring:form>
			</section>
		</section>
	</section>

<%@include file="footer.jsp"%>
</body>

</html>