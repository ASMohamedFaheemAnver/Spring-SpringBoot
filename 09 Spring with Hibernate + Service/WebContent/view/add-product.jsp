<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>

<head>
<title>Add product</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/css/style.css" />

</head>

<body>
	<h2>Add product</h2>
	<br />
	<form:form action="${pageContext.request.contextPath }/add-product" method="POST"
		modelAttribute="product">
		<p>Product name :</p>
		<form:input path="product_name" />
		<form:hidden path="product_id" />
		<br />
		<p>Cost</p>
		<form:input path="cost" />
		<br />
		<br />
		<input class="btn" type="submit" value="Add/Update product">
	</form:form>
	<br />
	<a href="${pageContext.request.contextPath }/">Home</a>
</body>
</html>







