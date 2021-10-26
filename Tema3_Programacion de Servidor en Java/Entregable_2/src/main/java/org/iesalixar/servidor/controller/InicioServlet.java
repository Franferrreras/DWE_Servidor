package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class InicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*" + "@"
			+ "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";

	private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InicioServlet() {
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
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cntraseña = (String)request.getParameter("password");
		HttpSession sesion = request.getSession();
		
		request.setCharacterEncoding("UTF-8");

		if (request.getParameter("usuario") != null 
				&& request.getParameter("password") != null
				&& request.getParameter("confirmar") != null
				&& request.getParameter("confirmar").equals(cntraseña) 
				&& EMAIL_PATTERN.matcher(request.getParameter("email")).matches()
				|| PASSWORD_PATTERN.matcher(request.getParameter("password")).matches()) {
			
			sesion.setAttribute("LOGUEADO", true);
			sesion.setAttribute("usuario", request.getParameter("usuario"));
			sesion.setAttribute("password", request.getParameter("password"));
			sesion.setAttribute("email", request.getParameter("email"));

			response.sendRedirect(request.getContextPath() + "/ReservaServlet");
			return;
		}
		
		response.sendRedirect(request.getContextPath());
	}

}
