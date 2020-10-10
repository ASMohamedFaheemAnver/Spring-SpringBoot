<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>Product list</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/style/css/style.css" />

</head>

<body>

	<h2>List of available products</h2>

	<!-- div for apply styling to table  -->
	<div class="datagrid">
		<table>
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Cost($)</th>
				<th>Operation</th>
			</tr>

			<!-- loop over and print our customers -->
			<c:forEach var="product" items="${products}">

				<tr>
					<td>${product.product_id}</td>
					<td>${product.product_name}</td>
					<td>${product.cost}</td>
					<td>
						<a href="${pageContext.request.contextPath }/update-product-form/?id=${product.product_id}">Update</a>
					</td>
				</tr>

			</c:forEach>
		</table>
		<br/>
		<input class="btn" type="button" value="Add product" onclick="window.location.href='add-product-form'" />
	</div>
</body>
</html>




