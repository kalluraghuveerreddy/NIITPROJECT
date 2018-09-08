<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags"  prefix="springtag"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
       
<h1>Deactivated</h1>
<table class="table">
<thead>
          <tr>
              <th>user-id</th>
              <th>userName</th>
              <th>email</th>
              <th>mobile</th>
              <th>role</th>
              <th>status</th>
              <th>Activate/Deactivate</th>
              
           </tr>
</thead>
<tbody>
  <c:forEach items="${userList}" var="user">
      <c:if test="${user.status == false}">
          <tr>
                      <td><c:out value="${user.user_id }"></c:out></td>
                      <td><c:out value="${user.userName }"></c:out></td>
                      <td><c:out value="${user.email}"></c:out></td>
                      <td><c:out value="${user.mobile}"></c:out></td>
                      <td><c:out value="${user.role}"></c:out></td>
                       <td><c:out value="${user.status }"></c:out></td>  
                       <td><a href="accept/${user.user_id }"><input type="button" value="Activate"></a></td>
        </tr>
     </c:if>
  </c:forEach>
</tbody>
</table>


<h1>Activated</h1>

<table class="table">
<thead>
          <tr>
              <th>user_id</th>
              <th>userName</th>
              <th>email</th>
              <th>mobile</th>
              <th>role</th>
              <th>status</th>
              <th>Activate/Deactivate</th>
              
           </tr>
</thead>
<tbody>
  <c:forEach items="${userList}" var="user">
  <c:if test="${user.status == true }">
          <tr>
                      <td><c:out value="${user.user_id }"></c:out></td>
                      <td><c:out value="${user.userName }"></c:out></td>
                      <td><c:out value="${user.email}"></c:out></td>
                      <td><c:out value="${user.mobile}"></c:out></td>
                      <td><c:out value="${user.role}"></c:out></td>
                       <td><c:out value="${user.status }"></c:out></td>  
                       <td><a href="reject/${user.user_id}"><input type="button" value="Deactivate"></a></td>
        </tr>
 </c:if>
  </c:forEach>
</tbody>
</table>
     
</body>
</html>