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

		String usuario = request.getParameter("user");
		String password = request.getParameter("password");

		if (usuario != null && password != null) {

			UsuarioDaoImpl usuariodao = new UsuarioDaoImpl();

			Usuario user = usuariodao.getUser(usuario);

			if (user != null) {

				if (PasswordHashGenerator.checkPassword(password, user.getPassword())) {

					HttpSession session = request.getSession();
					
					String datosUsuario = user.getUsuario() + " " + user.getFirstName() + " " + user.getLastName();
					session.setAttribute("usuariodatos", datosUsuario);
					
					session.setAttribute("usuario", user.getUsuario());
					
					session.setAttribute("role", user.getRole());
					if (user.getRole().equals("admin")) {
						
						response.sendRedirect("Admin/Inicio");

					} else {

						response.sendRedirect("Inicio");
					}

				} else {

					request.setAttribute("error", "error en el longin");
					doGet(request, response);
				}

			} else {

				request.setAttribute("error", "El usuario no existe");
				doGet(request, response);
			}

		} else {
			request.setAttribute("error", "El campo usuario o contraseña está vacio");
			doGet(request, response);
		}

	}

}
