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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
		// TODO Auto-generated method stub
		String usuario = request.getParameter("user");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		if (!usuario.equals("") && !password.equals("") && !email.equals("")) {

			UsuarioDaoImpl usuariodao = new UsuarioDaoImpl();

			Usuario user = usuariodao.getUser(usuario);

			if (user != null) {

				if (PasswordHashGenerator.checkPassword(password, user.getPassword()) && email.equals(user.getEmail())) {

					HttpSession session = request.getSession();
					
					String datosUsuario = user.getUsuario() + " " + user.getFirstName() + " " + user.getLastName();
					session.setAttribute("usuariodatos", datosUsuario);
					
					session.setAttribute("usuario", user.getUsuario());
					
					session.setAttribute("role", user.getRole());
					
					System.out.println("dentro");
//					if (user.getRole().equals("admin")) {
//						
//						response.sendRedirect("Admin/Inicio");
//
//					} else {
//
//						response.sendRedirect("Inicio");
//					}
					
					if (user.getRole().equals("admin")) {
						session.setAttribute("admin", "admin");
					} else {
						session.setAttribute("usu", "usuario");
					}
					response.sendRedirect("Home");

				} else {

					request.setAttribute("error", "error en el longin");
					doGet(request, response);
				}

			} else {

				request.setAttribute("error", "El usuario no existe");
				doGet(request, response);
			}

		} else {
			request.setAttribute("error", "Todos los campos tienen que estar completos");
			doGet(request, response);
		}
		
	}

}
