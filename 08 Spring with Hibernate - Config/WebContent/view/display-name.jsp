<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span>Today is : ${date}</span>
	<br />
	<span>Hello ${first_name} </span>
	<br />
	<br />
	<span>List of members</span>
	<br> ${team}
	<br/>
	<c:forEach var="name" items="${team}">
		<span>${name}</span><br/>
	</c:forEach>
	
</body>
</html>