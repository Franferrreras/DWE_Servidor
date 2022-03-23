package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.trasacciones.UdPayment;

/**
 * Servlet implementation class RemovePayment
 */
@WebServlet("/RemovePayment")
public class RemovePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemovePayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UdPayment udPayment = new UdPayment();
		
		int customerNumber = Integer.parseInt((String)request.getParameter("cn"));
		String checkNumber = request.getParameter("checknum");
		
		try {
			udPayment.deletePayment(customerNumber, checkNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		response.sendRedirect(request.getContextPath()+"/TablaClienteServlet");
	}

}
