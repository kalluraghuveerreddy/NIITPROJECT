<!DOCTYPE html>
<html>
<head>
<title>vendor Login Page</title>


<link rel="stylesheet" type="text/css" href="loginvendor.css">
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
				<form class="form-container" action="vendorloginprocess"
					method="post">
					<h2>Login</h2>
					<div class="form-group">
						<label for="vendor_email">Email address</label> <input
							type="email" class="form-control" id="vendor_email"
							name="vendor_email" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label for="vendor_password">Password</label> <input
							type="password" class="form-control" id="vendor_password"
							name="vendor_password" placeholder="Enter Password">
					</div>

					<button type="submit" class="btn btn-primary btn-block">Login</button>
				</form>
			</section>
		</section>
	</section>

<%@include file="footer.jsp"%>
</body>

</html>