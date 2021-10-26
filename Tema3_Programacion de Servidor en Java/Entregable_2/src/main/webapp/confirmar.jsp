<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="reserva" scope="request"  class="org.iesalixar.servidor.models.Reserva" ></jsp:useBean>
	<div class="container">
		<p>Fecha de Inicio <%=reserva.getFechaInicio() %></p>
		<p>Fecha de Fin <%= reserva.getFechaFin() %></p>
		<p>Número personas <%= reserva.getNumPersonas() %></p>
		<h3>Servicios</h3>
		<ul>
			<%
				String[] servicios = reserva.getServicios();
				if (servicios.length == 0) {
			%>
			<li>No hay servicios seleccionados</li>
			
			<% } else { %>
			
				<% for (String a:servicios) { %>
					<li><%= a %></li>
				<% } %>
			<%
			}
			%>
		</ul>
	</div>
</body>
</html>