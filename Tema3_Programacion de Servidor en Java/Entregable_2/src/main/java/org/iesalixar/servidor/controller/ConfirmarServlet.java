package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.models.Reserva;

/**
 * Servlet implementation class ConfirmarServlet
 */
@WebServlet("/ConfirmarServlet")
public class ConfirmarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession sesion = request.getSession();
		
		if (!sesion.isNew() && sesion.getAttribute("LOGUEADO")!= null && (boolean)sesion.getAttribute("LOGUEADO")) {
			
			Reserva reserva = new Reserva();
			reserva.setFechaInicio((String)sesion.getAttribute("fecha_inicio"));
			reserva.setFechaFin((String)sesion.getAttribute("fecha_fin"));
			reserva.setNumPersonas((String)sesion.getAttribute("num_personas"));
			reserva.setServicios((String[])sesion.getAttribute("servicios"));
			
			request.setAttribute("reserva", reserva);
			
			request.getRequestDispatcher("confirmar.jsp").forward(request, response);
			return;
		}
		
		sesion.invalidate();
		response.sendRedirect(request.getContextPath());
	}

}
