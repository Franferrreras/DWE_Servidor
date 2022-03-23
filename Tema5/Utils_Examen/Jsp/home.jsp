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
</head>
<body>
	<div class ="container">
		<c:if test="${sessionScope.noadmin != null }">
			<div class="usuario">
				<jsp:include page="include/barra_usuario.jsp"></jsp:include>
				<div class="cat">
					<h1>Categoria disponibles</h1>
					<div>
						<ul>
							<c:forEach items="${categorias}" var="c">
								<li><a href="MostrarProductos?cat=${c.productLine}">${c.productLine}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${sessionScope.admin != null }">
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
				<div>
					<ul>
						<li><a href="Admin/Empleados">Mostrar Empleados</a></li>
						<li><a href="">Añadir Empleados</a></li>
					</ul>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>