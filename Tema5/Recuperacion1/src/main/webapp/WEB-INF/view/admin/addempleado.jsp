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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="../css/formulario.css">
<link rel="stylesheet" href="../css/barra.css">
</head>
<body>
	<div class="container">
		<div>
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
					<div>Está logueado como: ${usuario}</div>
					<div><a href="../Logout"><fmt:message key="logout"/></a></div>
				</div>
			</nav>
		</div>
		<div class="formulario">
			<form action="post">
				<label for="numero">Nombre Empleado</label>
				<input type="number" name="numero" required/>
				<label for="apellidos">Apellidos</label>
				<input type="text" name="apellidos" required />
				<label for="nombre">Nombre</label>
				<input type="text" name="nombre" required />
				<label for="extension">Extensión</label>
				<input type=""text name="extension" required />
				<label for="puesto">Puesto</label>
				<input type="text" name="puesto" required />
				<label for="office">Oficina</label>
				<select name="office">
					<c:forEach items="${oficinas}" var="o">
						<option value="${o.officeCode}">${o.city}</option>
					</c:forEach>
				</select>
				<label for="jefe">Jefe</label>
				<select name="jefe">
					<c:forEach items="${jefes}" var="j">
						<option value="${j.reportsTo}">${j.firstName} ${j.lastName}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Añadir Empleado">
			</form>
		</div>
	</div>
</body>
</html>