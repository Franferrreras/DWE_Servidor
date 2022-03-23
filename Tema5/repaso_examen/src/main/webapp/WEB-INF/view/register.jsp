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
		<form method="post">
			<label for="usuario">Usuario</label>
			<input type="text" id="usuario" name="usuario" />
			<label for="email">Email</label>
			<input type="email" id="email" name="email"/>
			<label for="password">password</label>
			<c:if test="${error!=null}">
				<p class="err">${error}</p>
			</c:if>
			<input type="password" id="password" name="password"/>
			<input type="submit" value="REGISTRAR" />
		</form>
	</div>
</body>
</html>