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
		<div><a href="Main">salir</a></div>
		<div class="formulario">
			<form method="post">
				<label for="user"><fmt:message key="user" /></label> <br>
				<input type="text" name="user" class="w3-input"/> <br>
				<label for="first_name"><fmt:message key="first_name" /></label> <br>
				<input type="text" name="first_name" class="w3-input"/> <br>
				<label for="last_name"><fmt:message key="last_name" /></label> <br>
				<input type="text" name="last_name" class="w3-input"/> <br>
				<label for="email"><fmt:message key="email" /></label><br>
				<input type="text" name="email" class="w3-input"/> <br>
				<label for="password"><fmt:message key="password" /></label> <br>
				<input type="password" name="password"  class="w3-input" /> <br>
				<label for="role"><fmt:message key="roll" /></label> <br>
				<input type="text" name="role" class="w3-input"/> <br>
				<input type="submit" name="enviar" value="Resgistrar" />
			</form>
			<c:if test="${mensaje != null}">
				<div>${mensaje}</div> 
			</c:if>
		</div>
	</div>
</body>
</html>