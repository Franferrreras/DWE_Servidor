package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.DaoPayments;
import org.iesalixar.servidor.model.Payments;

/**
 * Servlet implementation class TablaPaymentsServlet
 */
@WebServlet("/TablaPaymentsServlet")
public class TablaPaymentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TablaPaymentsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DaoPayments daoPayments = new DaoPayments();
		
		ArrayList<Payments> paymentsList = daoPayments.getAllPayments();
		
		request.setAttribute("payments", paymentsList);
		
		request.getRequestDispatcher("WEB-INF/view/index.jsp").forward(request, response);
	}

}
