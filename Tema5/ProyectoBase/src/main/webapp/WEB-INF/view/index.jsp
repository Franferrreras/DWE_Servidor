<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setBundle basename="interface" />  
<jsp:include page="include/bootstrap.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>CustomerNumber</th>
							<th>CustomerName</th>
							<th>ContactLastName</th>
							<th>ContactFirstName</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clientes}" var="c">
							<tr>
								<td>${c.customerNumber}</td>
								<td>${c.customerName}</td>
								<td>${c.contactLastName}</td>
								<td>${c.contactFirsttName}</td>
								<td>borrar</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>