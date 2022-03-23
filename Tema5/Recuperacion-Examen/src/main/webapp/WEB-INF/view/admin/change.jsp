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
<link rel="stylesheet" href="../css/barra.css">
</head>
<body>
	<div class="container">
		<div>
			<nav class="menu">
				<div class="box1">
					<div><fmt:message key="init" /></div>
					<div><fmt:message key="addemployee" /></div>
				</div>
				<div class="box2">
					<div>Zona Administración</div>
				</div>
				<div class="box3">
					<div>Está logueado como: ${usuario}</div>
					<div><a href="Logout"><fmt:message key="logout"/></a></div>
				</div>
			</nav>
		</div>
		<div class="formulario">
			<h4><fmt:message key="customer"/>: ${customer}</h4>
			<h4><fmt:message key="contact"/>: ${name}</h4>
			<form action="post">
				<label for="emp">Empleado asignado</label>
				<select name="emp">
					<c:forEach items="${employees}" var="e">
						<option value="${e.employeeNumber}">${e.firstName}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Cambiar Empleado">
			</form>
		</div>
	</div>
</body>
</html>