<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td>product_brand:</td>
			<td>${laptop.product_brand}</td>
		</tr>
		<tr>
			<td>laptopName:</td>
			<td>${laptop.laptopName }</td>
		</tr>
		<tr>
			<td>harddisk:</td>
			<td>${laptop.harddisk }</td>
		</tr>
		<td>ram:</td>
		<td>${laptop.ram}</td>
		<tr>
			<td>processor:</td>
			<td>${laptop.processor }</td>
		</tr>
		<tr>
			<td>product_price:</td>
			<td>${laptop.product_price }</td>
		</tr>

	</table>
</body>
</html>