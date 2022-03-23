<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="barra.jsp"/>
	<jsp:useBean id="usuarioBean" class="org.iesalixar.servidor.models.Usuario" scope="request" />
	<h1>Zona usuario</h1>
	<%= usuarioBean.getNombre() %>
</body>
</html>