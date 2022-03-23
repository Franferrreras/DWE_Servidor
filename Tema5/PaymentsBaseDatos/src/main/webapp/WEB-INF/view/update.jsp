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
</head>
<body>
	<div class="container">
		<form method="post">
			<div>
				<h1>Actualice los datos de cantidad o fecha</h1>	
				<p>${pago.customerNumber}</p>
				<p>${pago.checkNumber}</p>
				<p><input type="date" name="date" placeholder="${pago.paymentDate}"/></p>
				<p><input type="text" name="cantidad" placeholder="${pago.amount}"/></p>	
				<p><input type="submit" value="Enviar" name="submit"></p>
			</div>
		</form>
	</div>
</body>
</html>