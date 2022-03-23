package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dao.UsuarioDaoImpl;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.util.PasswordHashGenerator;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		if (user != null && password!= null) {
			
			UsuarioDaoImpl usuariodao = new UsuarioDaoImpl();
			Usuario usuario = usuariodao.getUsuario(user);
			
			if (usuario!=null) {
				
				if (PasswordHashGenerator.checkPassword(password, usuario.getPassword())) {
					
					HttpSession session = request.getSession();
					String nombreUsuario = usuario.getUsuario() + " " + usuario.getFirstName() + " " + usuario.getLastName();					
					session.setAttribute("user", usuario.getUsuario());
					session.setAttribute("datos", nombreUsuario);
					session.setAttribute("email", usuario.getEmail());
					session.setAttribute("rol", usuario.getRole());
					
					System.out.println(nombreUsuario);
					if(usuario.getRole().equals("admin")) {
						response.sendRedirect(request.getContextPath()+"/Admin");
					} else {
						response.sendRedirect(request.getContextPath()+"/Usuario");
					}
				} else {
					request.setAttribute("error", "login invalido");
					doGet(request,response);
				}
				
			} else {
				
				request.setAttribute("error", "Usuario no existente");
				doGet(request,response);
				return;
			}
			
		}
	}

}
