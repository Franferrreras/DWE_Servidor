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
<link rel="stylesheet" href="css/barra.css">
</head>
<body>
	<div class="container">
		<nav class="menu">
			<div class="box1">
				<div><fmt:message key="init" /></div>
			</div>
			<div class="box2">
				<div>Zona Usuario</div>
			</div>
			<div class="box3">
				<div><a href="Logout">Salir</a></div>
			</div>
		</nav>
	</div>
</body>
</html>