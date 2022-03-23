package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.CustomerDaoImpl;
import org.iesalixar.servidor.dao.EmployeeDaoImpl;
import org.iesalixar.servidor.model.Employee;

/**
 * Servlet implementation class ChangeAssigmentServlet
 */
@WebServlet("/ChangeAssigmentServlet")
public class ChangeAssigmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeAssigmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String customer = (String) request.getParameter("cn");
		String name = (String) request.getParameter("name");
		int empleado = Integer.parseInt((String) request.getParameter("ne")) ;
		
		EmployeeDaoImpl employeedao = new EmployeeDaoImpl();
		
		ArrayList<Employee> list_employee = (ArrayList<Employee>) employeedao.getEmployeList();
		
		request.setAttribute("customer", customer);
		request.setAttribute("name", name);
		request.setAttribute("employees", list_employee);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/change.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("Home");
	}

}
