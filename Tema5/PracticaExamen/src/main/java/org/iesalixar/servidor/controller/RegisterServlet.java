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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/view/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		UsuarioDaoImpl usuariodao = new UsuarioDaoImpl();
		Usuario user = null;
		String usuario = request.getParameter("user");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String roll = request.getParameter("role");
		String firstN = request.getParameter("first_name");
		String lastN = request.getParameter("last_name");

		if (usuario.equals("") || email.equals("") || password.equals("") || roll.equals("") || firstN.equals("") || lastN.equals("")) {

			request.setAttribute("mensaje", "Todo los campos tienen que estar completos");
			doGet(request, response);

		} else {

			user = usuariodao.getUser(usuario);

			if (user == null) {

				password = PasswordHashGenerator.hashPassword(password);
				user = new Usuario();

				user.setUsuario(usuario);
				user.setFirstName(firstN);
				user.setLastName(lastN);
				user.setEmail(email);
				user.setPassword(password);
				user.setRole(roll);

				usuariodao.registerUser(user);

				request.setAttribute("mensaje", "Usuario registrado");
				doGet(request, response);

			} else {

				request.setAttribute("mensaje", "El usuario introducido ya existe");
				doGet(request, response);
			}

		}

	}

}
