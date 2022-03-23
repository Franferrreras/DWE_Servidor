<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="usuario">
			<nav class="menu">
				<div class="box1"><fmt:message key="init" /></div>
				<div class="box2">Zona Usuario</div>
				<div class="box3"><a href="">Salir</a></div>
			</nav>
		</div>
		<div class="tabla">
			<c:choose>
				<c:when test="${employees!=null and employees.size() > 0 }">
					<table>
						<thead>
							<tr>
								<td>Nombre</td>
								<td>Descripcion</td>
								<td>Fabricante</td>
								<td>Compra</td>
								<td>Stock</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${products}" var="p">
								<tr>
									<td>${p.productName}</td>
									<td>${p.productDescription}</td>
									<td>${p.productVendor}</td>
									<td>${p.buyPrice}</td>
									<td>${p.quantityInStock}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>