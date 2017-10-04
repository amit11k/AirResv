<%@page import="com.capgemini.airline.beans.Passenger"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList" %>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%!ArrayList<Passenger> passList = new ArrayList<>(); %>
<script type="text/javascript">
function addPass(){

	var fName = document.getElementById("passFName");
	var lName = document.getElementById("passLName");
	var gender = document.getElementById("passGender");
	var age = document.getElementById("passAge");	
}
<%
	Passenger pass = new Passenger();
	pass.setFirstName("<script>document.writeln(fName)</script>");
	pass.setLastName("<script>document.writeln(lName)</script>");
	pass.setGender("<script>document.writeln(gender)</script>");
	pass.setAge(Integer.parseInt("<script>document.writeln(fName)</script>"));
%>
</script>
</head>
<body>
<form action="Controller?action=passengerList" method="post">
<table>
<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Gender</th>
	<th>Age</th>
</tr>

<tr>
	<td><input type="text" name="passFName"></td>
	<td><input type="text" name="passLName"></td>
	<td><input type="text" name="passGender"></td>
	<td><input type="text" name="passAge"></td>
</tr>
<tr><td><input type="button" name="txtAdd" value="Add Passenger" onclick="addPass()"></td></tr>
<tr><td><input type="submit" name="txtConfirm" value="Confirm"></td></tr>
</table>
</form>
</body>
</html>