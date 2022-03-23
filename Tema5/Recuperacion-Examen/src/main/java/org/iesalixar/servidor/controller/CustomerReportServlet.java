package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.CustomerDaoImpl;
import org.iesalixar.servidor.model.CustomerTotal;

/**
 * Servlet implementation class CustomerReportServlet
 */
@WebServlet("/CustomerReportServlet")
public class CustomerReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CustomerDaoImpl customerdao = new CustomerDaoImpl();
		
		int customerNumber = Integer.parseInt((String) request.getParameter("csn"));
		
		CustomerTotal customer = customerdao.getTotal(customerNumber);
		
		request.setAttribute("custotal", customer);
		
		request.getRequestDispatcher("WEB-INF/view/report.jsp").forward(request, response);
	}

}
