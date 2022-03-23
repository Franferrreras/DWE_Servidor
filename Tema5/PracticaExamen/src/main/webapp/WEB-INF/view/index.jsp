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
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="container">
		<c:if test="${sessionScope.usuario == null }">
			<div class="formulario">
				<form method="post">
					<label for="user"><fmt:message key="user" /></label> <br>
					<input type="text" name="user" class="w3-input"/> <br>
					<label for="password"><fmt:message key="password" /></label> <br>
					<input type="password" name="password" class="w3-input"/> <br>
					<input type="submit" name="enviar" value="Entrar" />
				</form>
				<c:if test="${error != null}">
					<p>${error}</p>
				</c:if>
				<div class="reg"><a href="Register">¿No tienes cuenta?. Registrate</a></div>
			</div>
		</c:if>
		<c:if test="${sessionScope.usuario != null }">
			<div>Ya esta logueado</div>
			<div><a href="Logout"><fmt:message key="out"/></a></div>
		</c:if>
	</div>
</body>
</html>