<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/search.css">
</head>
<body>
	<div class="container">
		<div>
			<form method="post">
				<input type="search" placeholder="Search" name="busqueda" required/>
				<input type="submit" placeholder="search"/>
			</form>
		</div>
	</div>
	<div>
		<c:choose>
			<c:when test="${productos!=null and productos.size() > 0}">
				<table>
					<thead>
						<tr>
							<td>Code</td>
							<td>Name</td>
							<td>Categoria</td>
							<td>Scale</td>
							<td>Vendedor</td>
							<td>Descripcion</td>
							<td>Stock</td>
							<td>Precio</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productos}" var="p">
							<tr>
								<td>${p.productCode}</td>
								<td>${p.productName }</td>
								<td>${p.productLine}</td>
								<td>${p.productScale}</td>
								<td>${p.productVendor}</td>
								<td>${p.productDescription}</td>
								<td>${p.quantityInStock}</td>
								<td>${p.buyPrice}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
		</c:choose>

	</div>
</body>
</html>