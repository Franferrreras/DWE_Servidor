package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.models.Reserva;

/**
 * Servlet implementation class ReservaServlet
 */
@WebServlet("/ReservaServlet")
public class ReservaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesion = request.getSession();
		if (!sesion.isNew() && sesion.getAttribute("LOGUEADO") != null && (boolean) sesion.getAttribute("LOGUEADO")) {
			request.getRequestDispatcher("reserva.jsp").forward(request, response);
			return;
		}
		
		sesion.invalidate();
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sesion = request.getSession();
		
		if (!sesion.isNew() && sesion.getAttribute("LOGUEADO") !=null && (boolean)sesion.getAttribute("LOGUEADO")) {
			
			sesion.setAttribute("fecha_inicio", request.getParameter("finicio"));
			sesion.setAttribute("fecha_fin", request.getParameter("ffin"));
			sesion.setAttribute("num_personas", request.getParameter("numeropersonas"));
			sesion.setAttribute("servicios", request.getParameterValues("servicio"));
			
			
			response.sendRedirect(request.getContextPath()+"/ConfirmarServlet");
			return;
		} 
		
		sesion.invalidate();
		response.sendRedirect(request.getContextPath());
	}

}
