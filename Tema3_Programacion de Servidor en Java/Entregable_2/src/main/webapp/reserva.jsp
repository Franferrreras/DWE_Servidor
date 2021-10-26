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
		<header>
			<a href="<%= request.getContextPath()+"/InicioServlet" %>"><input type="button" class="button" value="SALIR"></a>
			<p><span>Usuario: </span><%=(String)session.getAttribute("usuario")%>  <%= new Date()  %></p>
			<h1>DATOS DE LA RESERVA</h1>
		</header>
		<main>
			<div class="formulario">
				<form method="post">
					<p>
						<label for="finicio">Fecha de Inicio</label> <input type="date" name="finicio" id="finicio" required>
					</p>
					<p>
						<label for="ffin">Fecha de Fin</label> <input type="date" name="ffin" id="ffin" required>
					</p>
					<p>
						<label for="numeropersonas">Número de personas</label> <input type="number" name="numeropersonas" id="numeropersonas" required>
					</p>

					<div class="checkboxss">
						<h3>SERVICIOS</h3>
						<div class="col1">
							<input type="checkbox" name="servicio" value="Wifi"><label for="wifi">Wifi</label>
							<input type="checkbox" name="servicio" value="Toallas"><label for="toallas">Toallas</label> 
							<input type="checkbox" name="servicio" value="Desayuno"><label for="desayuno">Desayuno</label>
						</div>
						<div class="col2">
							<input type="checkbox" name="servicio" id="limpieza" value="Limpieza"><label for="limpieza">Limpieza</label> 
							<input type="checkbox" name="servicio" id="ruta" value="Ruta_Elegir"><label for="ruta" >Ruta Elegir</label>
							<input type="checkbox" name="servicio" id="sauna" value="Sauna"><label for="sauna" >Sauna</label>
						</div>
					</div>
					<p>
						<input type="submit" value="RESERVAR">
					</p>
				</form>

			</div>
		</main>
	</div>
</body>
</html>