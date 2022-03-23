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
<link rel="stylesheet" href="../css/employee.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="admin">
		<div>
			<nav class="menu">
				<div class="box1">
					<div><fmt:message key="init" /></div>
					<div><fmt:message key="showemployees" /></div>
					<div><fmt:message key="addemployee" /></div>
				</div>
				<div class="box2">
					<div>Zona Admin</div>
				</div>
				<div class="box3">
					<div>Está logueado como: ${usuario}</div>
					<div><a href="../Logout"><fmt:message key="logout"/></a></div>
				</div>
			</nav>
		</div>
		<div class="tabla">
			<div class="add"><a href="AddEmpleado"><fmt:message key="add" /></a></div>
			<h1>Empleados</h1>
			<table>
				<thead>
					<tr>
						<td><fmt:message key="number" /></td>
						<td><fmt:message key="last_name" /></td>
						<td><fmt:message key="name" /></td>
						<td><fmt:message key="mark" /></td>
						<td><fmt:message key="office" /></td>
						<td><fmt:message key="boss" /></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${employees}" var="e">
						<tr>
							<td>${e.employeeNumber} </td>
							<td>${e.lastName} </td>
							<td>${e.firstName} </td>
							<td>${e.jobTitle} </td>
							<td>${e.office}</td>
							<td>${e.reportsTo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>