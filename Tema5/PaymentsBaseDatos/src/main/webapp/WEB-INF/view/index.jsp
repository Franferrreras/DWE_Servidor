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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
<link rel="stylesheet" href="css/index.css">
</head>
<body>
	<div class="container">
		<table>
			<thead>
				<tr>
					<th><fmt:message key="customer_number" /></th>
					<th><fmt:message key="check_number" /></th>
					<th><fmt:message key="payment_date" /></th>
					<th><fmt:message key="amount" /></th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${payments}" var="payment">
					<tr>
						<td>${payment.customerNumber}</td>
						<td>${payment.checkNumber}</td>
						<td>${payment.paymentDate}</td>
						<c:choose>
							<c:when test="${payment.amount >=0 and payment.amount<10000}">
								<td style="color:red">${payment.amount}</td>	
							</c:when>
							<c:when test="${payment.amount >=10000 and payment.amount<20000}">
								<td style="color:blue">${payment.amount}</td>	
							</c:when>
							<c:when test="${payment.amount >=20000 and payment.amount<30000}">
								<td style="color:green">${payment.amount}</td>	
							</c:when>
							<c:otherwise>
								<td style="color:purple">${payment.amount}</td>
							</c:otherwise>
						</c:choose>
						<td>
							<a href="UpdatePayment?cn=${payment.customerNumber}&checknum=${payment.checkNumber}"><i class="fas fa-edit"></i></a>
							<a href="RemovePayment?cn=${payment.customerNumber}&checknum=${payment.checkNumber}"><i class="fas fa-trash-alt"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>