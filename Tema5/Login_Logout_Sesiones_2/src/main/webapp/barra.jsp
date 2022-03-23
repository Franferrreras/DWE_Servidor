<%@ page import="org.iesalixar.servidor.models.Usuario" %>
<div>
	<h4>
		<%
			
			Usuario user = (Usuario) session.getAttribute("usuario");
		
			out.println(user.getNombre());
		
		%>
	</h4>
	<a href="Logout">Logout</a>
</div>