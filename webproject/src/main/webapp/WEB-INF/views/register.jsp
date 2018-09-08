<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

  <h2>Register</h2>

  <spring:form action="registerprocess" methos="post" modelAttribute="user">


    <div class="form-group">

            <spring:label path="userName">Name:</spring:label>
      
            <spring:input type="text" class="form-control"  placeholder="Enter name" path="userName"/>
      
    </div>
    <div class="form-group">

           <spring:label path="email">Email:</spring:label>
          
           <spring:input type="email" class="form-control" placeholder="Enter email" path="email"/>
          
    </div>
    <div class="form-group">

            <spring:label path="mobile">Mobile:</spring:label>
              
            <spring:input type="phone" class="form-control"  placeholder="Enter email" path="mobile"/>
              
    </div>

    <div class="form-group">

      <spring:label path="password">Password:</spring:label>

      <spring:input type="email" class="form-control"  placeholder="Enter email" path="password"/>

    </div>

    <div class="form-group">
      <spring:label path="role">Role:</spring:label>
      <spring:select class="form-control" path="role">
        <spring:option value="vendor" label="vendor"></spring:option>>
        <spring:option value="customer" label="customer"></spring:option>>
      
      </spring:select>
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>

  </spring:form>

</div>

​

</body>
</html>