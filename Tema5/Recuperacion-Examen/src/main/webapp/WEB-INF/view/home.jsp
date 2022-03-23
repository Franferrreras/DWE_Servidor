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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="css/barra.css">
<link rel="stylesheet" href="css/tabla.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
</head>
<body>
	<div class ="container">
		<c:if test="${sessionScope.noadmin != null }">
			<div class="usuario">
				<jsp:include page="include/barra_usuario.jsp"></jsp:include>
			   	<div class="tabla">
					<table>
						<thead>
							<tr>
								<td><fmt:message key="cusnumber" /></td>
								<td><fmt:message key="cusname" /></td>
								<td><fmt:message key="contactname"/></td>
								<td><fmt:message key="surname" /></td>
								<td><fmt:message key="phone" /></td>
								<td><fmt:message key="option" /></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${customers}" var="c">
								<tr>
									<td>${c.customerNumber} </td>
									<td>${c.customerName}</td>
									<td>${c.contactFirsttName} </td>
									<td>${c.contactLastName} </td>
									<td>${c.phone} </td>
									<td><a href="CustomerReport?csn=${c.customerNumber}"><i class="fas fa-eye"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
		<c:if test="${sessionScope.admin != null }">
			<div class="admin">
				<div>
					<nav class="menu">
						<div class="box1">
							<div><fmt:message key="init" /></div>
							<div><fmt:message key="addemployee" /></div>
						</div>
						<div class="box2">
							<div>Zona Administración</div>
						</div>
						<div class="box3">
							<div>Está logueado como: ${usuario}</div>
							<div><a href="Logout"><fmt:message key="logout"/></a></div>
						</div>
					</nav>
				</div>
				<div class="tabla">
					<div class="add"><a href="AddEmpleado"><fmt:message key="add" /></a></div>
					<table>
						<thead>
							<tr>
								<td><fmt:message key="cusnumber" /></td>
								<td><fmt:message key="cusname" /></td>
								<td><fmt:message key="contactname"/></td>
								<td><fmt:message key="surname" /></td>
								<td><fmt:message key="phone" /></td>
								<td><fmt:message key="option" /></td>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${customers}" var="c">
								<tr>
									<td>${c.customerNumber} </td>
									<td>${c.customerName}</td>
									<td>${c.contactFirsttName} </td>
									<td>${c.contactLastName} </td>
									<td>${c.phone} </td>
									<td><a href="Admin/ChangeAssigment?cn=${c.customerName}&name=${c.contactFirsttName}&ne=${c.salesEmployeeNumber}&cusnumber=${c.customerNumber}"><i class="fas fa-users"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>