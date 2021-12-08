<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="formulario">
			<c:if test="${sessionScope.user==null}">
				<form method="post">
					<label for="user">Usuario</label> 
					<input type="text" id="user" name="user" /> 
					<label for="password">Contraseña</label> 
					<input
						type="password" id="password" name="password">
					<c:if test="${error!=null}">
						<p class="err">${error}</p>
					</c:if>
					<input type="submit" value="Entrar">
				</form>
				<p>
					<a href="Register">¿No tienes cuenta?. Registrate</a>
				</p>
			</c:if>
			<c:if test="${sessionScope.user!=null}">
				<p>Ya esta logueado</p>
			</c:if>
		</div>
	</div>
</body>
</html>