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
<link rel="stylesheet" href="../css/tabla.css">
<link rel="stylesheet" href="../css/nav.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<nav class="menu">
			<div class="box1">
				<div>
					<fmt:message key="init" />
				</div>
			</div>
			<div class="box2">
				<div>Mi nombre es ${sessionScope.usuariodatos}</div>
				<div>
					<a href="Logout"><fmt:message key="out" /></a>
				</div>
			</div>
		</nav>
		<div class="tabla">
			<c:choose>
				<c:when test="${products!=null and products.size() > 0 }">
					<table>
						<thead>
							<tr>
								<td><fmt:message key="code" /></td>
								<td><fmt:message key="name" /></td>
								<td><fmt:message key="category" /></td>
								<td><fmt:message key="stock" /></td>
								<td><fmt:message key="price" /></td>
								<td><fmt:message key="action" /></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${products}" var="p">
								<tr>
									<td>${p.productCode}</td>
									<td>${p.productName}</td>
									<td>${p.productLine}</td>
									<td>${p.quantityInStock}</td>
									<td>${p.buyPrice}</td>
									<td><i class="fas fa-pen"></i></td>
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