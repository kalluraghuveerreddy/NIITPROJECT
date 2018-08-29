<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <spring:form  action="updateprocess" method="post" modelAttribute="vendor">
 
      <spring:input path="vendor_name"/>
      <spring:input path="vendor_email"/>
      <spring:input path="vendor_mobile"/>
      <spring:input path="vendor_password"/>
      <input type="submit" value="signup"/>
     
  </spring:form>
</body>
</html>