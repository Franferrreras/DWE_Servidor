package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dao.UsuarioDaoImpl;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.util.PasswordHashGenerator;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String password = request.getParameter("password");
		String usuario  = request.getParameter("user");
		String email = request.getParameter("email");
		
		if (password != "" && usuario != "" && email != "") {
			
			UsuarioDaoImpl usuariodao = new UsuarioDaoImpl();
			
			Usuario usuario_login = usuariodao.getUser(usuario);
			
			if (usuario_login != null) {
				
				if (PasswordHashGenerator.checkPassword(password, usuario_login.getPassword()) && email.equals(usuario_login.getEmail())) {
					
					HttpSession session = request.getSession();
					
					String nombre_completo = usuario_login.getUsuario() + " " + usuario_login.getFirstName() + " " + usuario_login.getLastName();
					
					session.setAttribute("usuario", nombre_completo);
					
					if (usuario_login.getRole().equals("admin")) {
						
						session.setAttribute("admin", "admin");
						session.setAttribute("role", "admin");
						
					} else {
						session.setAttribute("noadmin", "usuario");
						session.setAttribute("role", "usuario");
					}
					
					response.sendRedirect("Home");
					
					
				} else {
					request.setAttribute("error", "La contraseña o correo no son correctos");
					doGet(request, response);
				}
				
			} else {
				request.setAttribute("error", "El usuario no existe");
				doGet(request, response);
			}
			
		} else {
			request.setAttribute("error", "No pueden haber campos vacios");
			doGet(request, response);
		}
		
	}

}
