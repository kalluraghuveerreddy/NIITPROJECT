
<!DOCTYPE html>

<html>

<head>

<title>Bootstrap Example</title>
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

	<div class="container">

		<!-- The Modal -->

		<div class="modal" id="loginModal">

			<div class="modal-dialog">

				<div class="modal-content">



					<!-- Modal Header -->

					<div class="modal-header">

						<h4 class="modal-title">LOGIN</h4>

						<button type="button" class="close" data-dismiss="modal">&times;</button>

					</div>



					<div class="container">

						<form action="">
							<div class="form-group">
								<label for="email">Email:</label> <input type="email"
									class="form-control" id="email" placeholder="Enter email"
									name="email">
							</div>
							<div class="form-group">
								<label for="pwd">Password:</label> <input type="password"
									class="form-control" id="pwd" placeholder="Enter password"
									name="pswd">
							</div>
							<div class="form-group form-check">
								<label class="form-check-label"> <input
									class="form-check-input" type="checkbox" name="remember">
									Remember me
								</label>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>



					<!-- Modal footer -->

					<div class="modal-footer">

						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>

					</div>



				</div>

			</div>

		</div>
		
	</div>		​
</body>

</html>

​

