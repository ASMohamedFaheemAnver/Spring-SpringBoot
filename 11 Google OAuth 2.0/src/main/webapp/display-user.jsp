<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User details!</title>
</head>
<body>
	<img alt="user img" src="<%= request.getAttribute("image") %>" />
	<span>Email : <%= request.getAttribute("email") %></span>
</body>
</html>