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
</head>
<body>
      
  
     
     <c:if test="${!empty userList }">
        <table>
           <tr>
              <th>userid</th>
              <th>name</th>
              <th>email</th>
              <th>mobile</th>
              <th>status</th>
           </tr>
           
           <c:forEach  items="${userList }"  var="vendor">
           
                 <tr>
                      <td><c:out value="${vendor.vendor_id }"></c:out></td>
                      <td><c:out value="${vendor.vendor_name }"></c:out></td>
                      <td><c:out value="${vendor.vendor_email}"></c:out></td>
                      <td><c:out value="${vendor.vendor_mobile}"></c:out></td>
                      <td><c:out value="${vendor.company_name}"></c:out></td>
                       <td><c:out value="${vendor.status }"></c:out></td>
                           
                 </tr>
           
           </c:forEach>
        
        </table>
        
        </c:if>
      
     
</body>
</html>