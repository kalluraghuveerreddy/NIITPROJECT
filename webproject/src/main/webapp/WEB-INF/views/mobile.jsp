<%@page isELIgnored="false" %>
<%@include file="contextpath.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<html>
<head>
<title>Add mobile Page</title>

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


	<%@include file="defaultvendorindex.jsp"%>
	<section class="container-fluid bg">
		<section class="row justify-content-center">
			<section class="col-12 col-sm-6 col-md-3">
				<spring:form class="form-container" action="${contextPath}/vendor/mobileprocess"
					method="post" modelAttribute="mobile" enctype="multipart/form-data">
					<h2>Add Mobile</h2>
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
					</div>
					<div class="form-group">
						<spring:label path="product_name">product Name</spring:label>
						<spring:input type="text" class="form-control" path="product_name"
							placeholder="Enter  product name" />
					</div>
					<div class="form-group">
						<spring:label path="product_price">product _price</spring:label>
						<spring:input type="text" class="form-control"
							path="product_price" placeholder="Enter  price" />
					</div>
					<div class="form-group">
						<spring:label path="ram">Ram</spring:label>
						<spring:input type="text" class="form-control" path="ram"
							placeholder="Enter  ram size" />
					</div>
					<div class="form-group">
						<spring:label path="name">Mobile Name</spring:label>
						<spring:input type="text" class="form-control" path="name"
							placeholder="Enter mobile name" />
					</div>

					<div class="form-group">
						<spring:label path="memory">Memory Size</spring:label>
						<spring:input type="text" class="form-control" path="memory"
							placeholder="Enter memory size" />
					</div>
					<div class="form-group">
						<spring:label path="screenSize">Screen Size</spring:label>
						<spring:input type="text" class="form-control" path="screenSize"
							placeholder="Enter screen size" />
					</div>
                    <div class="form-group">
						<spring:label path="numberOfProducts">Number Of Products</spring:label>
						<spring:input type="text" class="form-control" path="numberOfProducts"
							placeholder="Enter no of products" />
					</div>
					<div class="form-group">
						<spring:label path="image">Image</spring:label>
						<spring:input type="file" class="form-control" path="image"
						 />
					</div>

					<button type="submit" class="btn btn-primary btn-block">AddMobile</button>
				</spring:form>
			</section>
		</section>
	</section>
	
	<%@include file="footer.jsp"%>
</body>

</html>