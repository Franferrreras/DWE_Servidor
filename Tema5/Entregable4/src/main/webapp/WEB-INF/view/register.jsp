<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<label for="first_name">First name</label>
			<input type="text" id="first_name" name="first_name" required/>
			<label for="last_name">Last name</label>
			<input type="text" id="last_name" name="last_name" required/>
			<label for="email">Email</label>
			<input type="email" id="email" name="email" required/>
			<label for="password">password</label>
			<input type="password" id="password" name="password" required/>
			<c:if test="${error!=null}">
				<p class="err">${error}</p>
			</c:if>
			<input type="submit" value="REGISTRAR" />
		</form>
	</div>
</body>
</html>