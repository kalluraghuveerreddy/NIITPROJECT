<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <springform:form  action="registerprocess" method="post" modelAttribute="user">
    <table>
    
       
      <tr>
      <td><springform:label path="userName">Name:</springform:label></td>
      <td><springform:input path="userName"/></td>
      </tr>
      
        <tr>
      <td><springform:label path="email">Email:</springform:label></td>
      <td> <springform:input path="email"/></td>
      </tr>
     
        <tr>
      <td><springform:label path="mobile">Mobile:</springform:label></td>
      <td>    <springform:input path="mobile"/></td>
      </tr>
     
       <tr>
      <td><springform:label path="password">Password:</springform:label></td>
      <td>   <springform:input path="password"/></td>
      </tr>
      
       <tr>
        <td><springform:label path="role">Role:</springform:label></td>
         <td>
            <springform:select path="role">
                    <springform:options>vendor</springform:options>
                     <springform:options>customer</springform:options>
            </springform:select>
         <td>
       </tr>
       
    
       <tr><td><input type="submit" value="signup"/></td></tr>
      
   </table>
     
  </springform:form>
 
</body>
</html>