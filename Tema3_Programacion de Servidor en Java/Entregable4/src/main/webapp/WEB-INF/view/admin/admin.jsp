<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/general.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<nav>
			<div>Inicio</div>
			<div>
				<a href="Oficina">Buscar Officina</a>
			</div>
			<div>Esta usted logueado como ${sessionScope.user}</div>
			<div>
				<a href="Logout">Salir</a>
			</div>
		</nav>
		<div>
			<form method="post">
				<input type="search" placeholder="Search" name="busqueda" required />
				<input type="submit" placeholder="search" />
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
							<td>edit</td>
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
								<td><i class="fas fa-edit"></i></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
		</c:choose>

	</div>
</body>
</html>