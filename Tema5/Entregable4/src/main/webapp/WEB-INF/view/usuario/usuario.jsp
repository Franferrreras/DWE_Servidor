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
</head>
<body>
	<div class="container">
		<nav>
			<div>Inicio</div>
			<div>
				<a href="Oficina">Buscar Officina</a>
			</div>
			<div>Esta usted logueado como ${sessionScope.datos}</div>
			<div>
				<a href="Logout">Salir</a>
			</div>
		</nav>
		<div class="imagen">
			<img src="img/portada.jpg" />
		</div>
	</div>
</body>
</html>