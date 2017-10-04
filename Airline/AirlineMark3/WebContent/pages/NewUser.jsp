<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Controller?action=newUser" method="post">
<table>
<tr>
	<th>Username:</th>
	<td><input type="text" name="txtUnm"></td>
</tr>
<tr>
	<th>Email Id:</th>
	<td><input type="email" name="txtEmail"></td>
</tr>
<tr>
	<th>Mobile:</th>
	<td><input type="text" name="txtNum"></td>
</tr>
<tr>
	<th>Password:</th>
	<td><input type="password" name="txtPwd"></td>
</tr>
</table>
</form>
</body>
</html>