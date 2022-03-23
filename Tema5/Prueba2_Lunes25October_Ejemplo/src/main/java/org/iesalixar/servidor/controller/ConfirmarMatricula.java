package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmarMatricula
 */
@WebServlet("/ConfirmarMatricula")
public class ConfirmarMatricula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarMatricula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		
		if (!sesion.isNew()) {
			 String correo = (String) sesion.getAttribute("correo");
			 
			 if (correo!=null && correo.equals("alum.fferrerasf.2020@iesalixar.org")) {
				 
				 request.getRequestDispatcher("confirmar.jsp");
				 return;
				 
			 }
		}
		
		sesion.invalidate();
		response.sendRedirect(request.getContextPath());
		
	}

}
