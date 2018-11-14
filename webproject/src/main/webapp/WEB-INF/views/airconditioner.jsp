<%@page isELIgnored="false"%>
<%@include file="contextpath.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<html>
<head>
<title>Add Airconditioner</title>

<link rel="stylesheet" type="text/css" href="product.css">
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

	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">
				<spring:form class="form-container"
					action="${contextPath}/vendor/airconditionerprocess" method="post"
					modelAttribute="airconditioner" enctype="multipart/form-data">
					<h2>Add Air Conditioner</h2>
					<div class="form-group">
						<spring:label path="subCategory.subCategory_id">SubCategory ID</spring:label>
						<spring:input class="form-control"
							path="subCategory.subCategory_id" type="hidden"
							value="${subCategory_id }" placeholder="Enter  subcategory id" />
					</div>
					<div class="form-group">
						<spring:label path="vendor.vendor_id">Vendor Id</spring:label>
						<spring:input class="form-control" path="vendor.vendor_id"
							type="hidden" value="${vendor_id }"
							placeholder="Enter  vendor  id" />
					</div>
					<div class="form-group">
						<spring:label path="product_brand">Product Brand</spring:label>
						<spring:input type="text" class="form-control"
							path="product_brand" placeholder="Enter  brand" />
							<span style="color:red"><spring:errors path="product_brand" ></spring:errors></span>
					</div>
					<div class="form-group">
						<spring:label path="product_name">product Name</spring:label>
						<spring:input type="text" class="form-control" path="product_name"
							placeholder="Enter  product name" />
							<span style="color:red"><spring:errors path="product_brand" ></spring:errors></span>
					</div>
					<div class="form-group">
						<spring:label path="product_price">product _price</spring:label>
						<spring:input type="text" class="form-control"
							path="product_price" placeholder="Enter  price" />
							<span style="color:red"><spring:errors path="product_price" ></spring:errors></span>
					</div>
					<div class="form-group">
						<spring:label path="name">Name</spring:label>
						<spring:input type="text" class="form-control" path="name"
							placeholder="Enter  name" />
							<span style="color:red"><spring:errors path="name" ></spring:errors></span>
					</div>


					<div class="form-group">
						<spring:label path="voltage">Voltage</spring:label>
						<spring:input type="text" class="form-control" path="voltage"
							placeholder="Enter voltage" />
							<span style="color:red"><spring:errors path="voltage" ></spring:errors></span>
					</div>
					<div class="form-group">
						<spring:label path="modelNo">Model Nmber</spring:label>
						<spring:input type="text" class="form-control" path="modelNo"
							placeholder="Enter model number" />
							<span style="color:red"><spring:errors path="modelNo" ></spring:errors></span>
					</div>
					<div class="form-group">
						<spring:label path="numberOfProducts">Number Of Products</spring:label>
						<spring:input type="text" class="form-control"
							path="numberOfProducts" placeholder="Enter no of products" />
							<span style="color:red"><spring:errors path="numberOfProducts" ></spring:errors></span>
					</div>
					<div class="form-group">
						<spring:label path="image">Image</spring:label>
						<spring:input type="file" class="form-control" path="image" />
						<span style="color:red"><spring:errors path="image" ></spring:errors></span>
					</div>

					<button type="submit" class="btn btn-primary btn-block">Add
						Airconditioner</button>
				</spring:form>
			</section>
		</section>
	</section>

</body>

</html>