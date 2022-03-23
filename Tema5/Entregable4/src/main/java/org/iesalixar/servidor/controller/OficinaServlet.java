package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.OfficeDaoImpl;
import org.iesalixar.servidor.model.Office;

/**
 * Servlet implementation class OficinaServlet
 */
@WebServlet("/OficinaServlet")
public class OficinaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OficinaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		OfficeDaoImpl oficinadao = new OfficeDaoImpl();
		
		ArrayList<Office> listOffices = oficinadao.getAllOffice();
		request.setAttribute("offices", listOffices);
		request.getRequestDispatcher("WEB-INF/view/usuario/oficina.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		OfficeDaoImpl oficinadao = new OfficeDaoImpl();
		
		String city = request.getParameter("oficinas");
		
		Office office = oficinadao.getOffice(city);
		
		request.setAttribute("infof", office);
		doGet(request, response);
	}

}
