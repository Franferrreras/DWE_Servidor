package org.iesalixar.servidor.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.UsuarioDaoImpl;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.util.PasswordHashGenerator;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.getRequestDispatcher("WEB-INF/view/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		
		if (usuario != null && password!= null && email != null) {
			
			UsuarioDaoImpl usuariodao = new UsuarioDaoImpl();
			
		    Usuario user = usuariodao.getUsuario(usuario);
		    
		    if (user != null) {
		    	request.setAttribute("error", "Usuario existente");
		    	doGet(request,response);
		    	return;
		    } else {
		    	password = PasswordHashGenerator.hashPassword(password);
		    	user.setUsuario(usuario);
		    	user.setEmeail(email);
		    	user.setPassword(password);
		    	user.setRole("usuario");
		    	usuariodao.insertUser(usuario, email, password, "usuario");
		    }
		}
		
		response.sendRedirect(request.getContextPath());
	}

}
