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
      
  
     
     <c:if test="${!empty userList }">
        <table  class="table table-bordered table-sm">
        <thead>
            <tr>
              <th>userid</th>
              <th>name</th>
              <th>email</th>
              <th>mobile</th>
              <th>role</th>
              <th>status</th>
              <th>operation</th>
              
           </tr>
        
        </thead>
           
           <c:forEach  items="${userList }"  var="user">
           <tbody>
           
               <tr>
                      <td><c:out value="${user.user_id }"></c:out></td>
                      <td><c:out value="${user.userName }"></c:out></td>
                      <td><c:out value="${user.email}"></c:out></td>
                      <td><c:out value="${user.mobile}"></c:out></td>
                      <td><c:out value="${user.role}"></c:out></td>
                       <td><c:out value="${user.status }"></c:out></td>   
                       
                       
                       <c:set var = "status" scope = "session" value = "${user.status}"/>
                       <c:choose>
                       <c:when test="${ status == false}">
                       <td><a href="accept/${user.user_id }"><input type="button" value="Activate"></a></td>
                       </c:when>
                       <c:when test="${ status == true}">
                       <td><a href="reject/${user.user_id}"><input type="button" value="Deactivate"></a></td>
                       </c:when>
                       </c:choose>
                       
                       
                    <%-- <td><a href="accept/${user.user_id }"><input type="button" value="accept" />  </a></td>
                    <td> <a href="reject/${user.user_id }"><input type="button" value="reject" />  </a></td> --%>
                           
                </tr>
           </tbody>
             
           
           </c:forEach>
        
        </table>
        
        </c:if>
      
     
</body>
</html>