<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<p><label for="nombre">Nombre </label><input type="text" name="nombre" required ></p>
		<p><label for="apellidos">Apellidos </label><input type="text" name="apellidos" required ></p>
		<p><label for="correo">Correo </label><input type="email" name="correo" required ></p>
		
		<p>
			<label for="primero">1</label><input type="radio" id="primero" name="curso"> 
			<label for="segundo">2</label><input type="radio" id="segundo" name="curso">	
		</p>
		
		<h2>
			<label for="formulario">Formulario</label>
			<select id="formulario" name="formulario">
				<option value="DAW">Desarrollo de Aplicaciones Web</option>
				<option value="SMR">SMR</option>
				<option value="DAM">DAM</option>
				<option value="FAPA">Farmacia</option>
			</select>
		</h2>
		<p><input type="radio" value="Enviar"></p>
	</form>
</body>
</html>