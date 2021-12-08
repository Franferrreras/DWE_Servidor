<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/general.css">
</head>
<body>
	<div class="container">
		<nav>
			<div>Inicio</div>
			<div>
				<a href="">Buscar Officina</a>
			</div>
			<div>Esta usted logueado como ${sessionScope.user}</div>
			<div>
				<a href="Logout">Salir</a>
			</div>
		</nav>
		<div class="off">
			<form method="post">
				<label for="oficinas">Oficinas</label> 
				<select id="oficinas" name="oficinas">
					<c:forEach items="${offices}" var="o">
						<option value="${o.city}">${o.city}</option>
					</c:forEach>
				</select> 
				<input type="submit" value="BUSCAR">
			</form>
		</div>
		<div>
			<c:choose>
				<c:when test="${infof != null}">
					<table>
						<thead>
							<tr>
								<td>Office Code</td>
								<td>City</td>
								<td>Phone</td>
								<td>AddressLine1</td>
								<td>AddressLine2</td>
								<td>State</td>
								<td>Country</td>
								<td>Code Postal</td>
								<td>territory</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>${infof.officeCode}</td>
								<td>${infof.city}</td>
								<td>${infof.phone}</td>
								<td>${infof.addressLine1}</td>
								<td>${infof.addressLine2}</td>
								<td>${infof.state}</td>
								<td>${infof.country}</td>
								<td>${infof.postalCode}</td>
								<td>${infof.territory}</td>
							</tr>
						</tbody>
					</table>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>