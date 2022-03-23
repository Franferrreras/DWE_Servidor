package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.Employee2DaoImpl;
import org.iesalixar.servidor.dao.OfficeDaoImpl;
import org.iesalixar.servidor.model.Employee;
import org.iesalixar.servidor.model.Office;

/**
 * Servlet implementation class AddEmpleadoServlet
 */
@WebServlet("/AddEmpleadoServlet")
public class AddEmpleadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmpleadoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		OfficeDaoImpl officedao = new OfficeDaoImpl();
		
		ArrayList<Office> list_office = officedao.getListOffice();
		
		request.setAttribute("oficinas", list_office);
		
		
		Employee2DaoImpl employeedao = new Employee2DaoImpl();
		
		ArrayList<Employee> list_boss = employeedao.getBoss();
		
		request.setAttribute("jefes", list_boss);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/addempleado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
