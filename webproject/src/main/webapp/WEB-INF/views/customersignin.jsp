<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@include file ="contextpath.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>customer Login Page</title>
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

<link rel="stylesheet" type="text/css" href="logincustomer.css">
</head>
<body>
<%@include file="defaultindex.jsp" %>
	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">
				<form class="form-container" action="customer/customerloginprocess"
					method="post">
					<h2>Login</h2>
					<div class="form-group">
						<label for="customer_email">Email </label> <input type="email"
							class="form-control" id="customer_email" name="customer_email"
							placeholder="Enter email">
					</div>
					<div class="form-group">
						<label for="customer_password">Password</label> <input
							type="password" class="form-control" id="customer_password"
							name="customer_password" placeholder="Enter Password">
					</div>

					<button type="submit" class="btn btn-primary btn-block">Login</button>
				</form>
			</section>
		</section>
	</section>
	<%@include file="footer.jsp"%>
</body>

</html>