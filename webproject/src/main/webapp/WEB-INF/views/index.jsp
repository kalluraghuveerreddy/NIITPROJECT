
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring" %>

<%-- <spring:url value="/resources/images/" var="images"></spring:url> --%>
<html>
<body>
<h2>Hello World!</h2>

<%-- <img src="${images}java.png"> --%>

<%-- <img src="<spring:url value="/resources/images/java.png"></spring:url>"> --%>
<a href="signup">Register</a>
<a href ="login">Login</a>
<a href="updatevendor">Update Vendor</a>

</body>
</html>
