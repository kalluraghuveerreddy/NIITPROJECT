<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@page isELIgnored="false" %>
<nav class="navbar navbar-expand-sm bg-danger navbar-dark ">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse " id="collapsibleNavbar">
		<ul class="navbar-nav">

            <li class="nav-item"><a class="nav-link text-white" href="/">Home</a></li>
            
			<!-- Dropdown -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle  text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Electronics </a>
				
				<div class="dropdown-menu">
				<c:forEach  items="${Electronics}" var="electronic">
					<a class="dropdown-item" href="products/${electronic.subCategory_id}">${electronic.subCategory_name}</a> 
		        </c:forEach>
				</div>
				
				</li>
				
			<!-- Dropdown -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Men </a>
				<div class="dropdown-menu">
					
				</div></li>
				
			<!-- Dropdown -->
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Women </a>
				<div class="dropdown-menu">
					
				</div></li>

		

			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle text-white" href="#" id="navbardrop"
				data-toggle="dropdown"> Home Appliances</a>
				<div class="dropdown-menu">
				
				</div></li>


			<li class="nav-item"><a class="nav-link text-white" href="#">Books</a></li>

	

		</ul>
	</div>
</nav>