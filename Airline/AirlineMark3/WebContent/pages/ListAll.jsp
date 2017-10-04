<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form >
<table border="2">
<c:forEach var="temp" items="${listFlight}">
		<tr>
			<th>${temp.company}</th>
			<th>${temp.flightId}</th>
			<th>${temp.departTime}</th>
			<th>${temp.arrivalTime}</th>
			<th>${temp.duration}</th>
			<th>${temp.Stops}</th>
			<th>${temp.price}</th>
			<th><a href="Controller?action=selectedFlight&id=${temp.flightId}">Select Flight</a></th>
		</tr>
</c:forEach>
</table>
</form>
</body>
</html>