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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container">
		<div class="admin">
				<nav class="menu">
					<div class="box1">
						<div><fmt:message key="init" /></div>
						<div><fmt:message key="showemployees" /></div>
						<div><fmt:message key="addemployee" /></div>
					</div>
					<div class="box2">
						<div>Zona Admin</div>
					</div>
					<div class="box3">
						<div>Está logueado como: ${usuariodatos}</div>
						<div><a href="Logout"><fmt:message key="out"/></a></div>
					</div>
				</nav>
			</div>
		<div class="tabla">
			<c:choose>
				<c:when test="${employees!=null and employees.size() > 0 }">
					<table>
						<thead>
							<tr>
								<td>Númeor</td>
								<td>Apellidos</td>
								<td>Nombre</td>
								<td>Puesto</td>
								<td>Oficina</td>
								<td>Jefe</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${employees}" var="e">
								<tr>
									<td>${e.employeeNumber}</td>
									<td>${e.lastName}</td>
									<td>${e.firstName}</td>
									<td>${e.jobTitle}</td>
									<td>${e.officeCode}</td>
									<td>${e.reportsTo}</td>
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