<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="../include/barra.jsp" />
		<table>
			<thead>
				<tr>
					<th>Customer number</th>
					<th>Check number</th>
					<th>Date</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${payments}" var="pago">
					<tr>
						<td>${pago.customerNumber}</td>
						<td>${pago.checkNumber}</td>
						<td>${pago.paymentDate}</td>
						<td>${pago.amount}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>