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
<link rel="stylesheet" href="../css/barra.css">
</head>
<body>
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
</body>
</html>