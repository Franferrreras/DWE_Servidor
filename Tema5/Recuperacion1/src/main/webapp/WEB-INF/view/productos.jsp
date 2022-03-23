<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="interface" />
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/tabla.css">
</head>
<body>
	<div class="container">
		<jsp:include page="include/barra_usuario.jsp"></jsp:include>
		<div class="tabla">
			<h1>Productos de la categoría ${products[0].productLine}</h1>
			<table>
				<thead>
					<tr>
						<td><fmt:message key="name" /></td>
						<td>Descripcion</td>
						<td>Fabricante</td>
						<td>Compra</td>
						<td>Stock</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="p">
						<tr>
							<td>${p.productName} </td>
							<td>${p.productDescription}</td>
							<td>${p.productVendor} </td>
							<td>${p.buyPrice} </td>
							<td>${p.quantityInStock} </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>