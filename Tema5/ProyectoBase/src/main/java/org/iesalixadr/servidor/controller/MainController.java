package org.iesalixadr.servidor.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixadr.servidor.dao.CustomerDaoImpl;
import org.iesalixadr.servidor.model.Customer;

/**
 * Servlet implementation class MainController
 */
@WebServlet("/MainController")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MainController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		CustomerDaoImpl customerDao = new CustomerDaoImpl();
		
		List<Customer> customer_list = customerDao.getCustomers();
		
		request.setAttribute("clientes", customer_list);
		
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}

}
