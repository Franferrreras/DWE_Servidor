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
<link rel="stylesheet" href="css/report.css">
</head>
<body>
	<div class="container">
		<jsp:include page="include/barra_usuario.jsp"></jsp:include>
		<div class="info">
			<h3><fmt:message key="cusname" />: ${custotal.customerName}</h3>
			<h3><fmt:message key="total" />: ${custotal.total}</h3>
			<h3><fmt:message key="numorder" />: ${custotal.numOrder}</h3>
		</div>
	</div>
</body>
</html>