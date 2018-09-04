<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <springform:form  action="updateprocess" method="post" modelAttribute="vendor">
    <table>
    
       <tr>
      <td><springform:label path="vendor_id">Id:</springform:label></td>
      <td><springform:input path="vendor_id"  readonly="true"/></td>
      </tr>
      <tr>
      <td><springform:label path="vendor_name">Name:</springform:label></td>
      <td><springform:input path="vendor_name" /></td>
      </tr>
      
        <tr>
      <td><springform:label path="vendor_email">Email:</springform:label></td>
      <td> <springform:input path="vendor_email" /></td>
      </tr>
     
        <tr>
      <td><springform:label path="vendor_mobile">Mobile:</springform:label></td>
      <td>    <springform:input path="vendor_mobile" /></td>
      </tr>
      
     
       <tr>
      <td><springform:label path="company_name">Company Name:</springform:label></td>
      <td>  <springform:input path="company_name"   /></td>
      </tr>
       <tr>
       
       <tr>
         <td><springform:label path="vendor_password">password:</springform:label></td>
      <td>  <springform:input path="vendor_password"   type="hidden" /></td>
       </tr>
        
       
      <%--   <tr>
      <td>Password:</td>
      <td>  <springform:/></td>
      </tr>  --%>
    
       <tr><td><input type="submit" value="update"/></td></tr>
      
   </table>
     
  </springform:form>
 
</body>
</html>