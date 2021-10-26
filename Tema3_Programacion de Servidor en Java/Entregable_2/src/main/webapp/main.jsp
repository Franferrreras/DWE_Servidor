<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%if (!session.isNew() && session.getAttribute("LOGUEADO")!=null && (boolean)session.getAttribute("LOGUEADO")) {%>
		<div class="salir">
			<a href="<%= request.getContextPath()+"/LogoutServlet" %>"><input type="button" class="button" value="SALIR"></a>
			<p><span>Usuario: </span><%=(String)session.getAttribute("usuario")%>  <%= new Date()  %></p>
		</div>
		
		<% } else { %>
		<div class="formulario">
			<form method="post">
				<p>
					<label for="usuario">Usuario</label>
					<input type="text" name="usuario" id="usuario" required>
				</p>
				<p>
					<label for="password">Password</label>
					<input type="password" name="password"  required>
				</p>
				<p>
					<label for="confirmar">Confirmar Password</label>
					<input type="password" name="confirmar" required>
				</p>
				<p>
					<label for="email">Email</label>
					<input type="email" name="email" required>
				</p>
				<p>
					<input type="submit" value="REGISTRASE" name="registrarse">
				</p>	
			</form>
		</div>
		<% } %>
	</div>
</body>
</html>