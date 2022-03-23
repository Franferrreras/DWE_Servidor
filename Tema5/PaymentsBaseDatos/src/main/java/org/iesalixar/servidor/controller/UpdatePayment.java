package org.iesalixar.servidor.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.servidor.dao.DaoPayments;
import org.iesalixar.servidor.model.Payments;
import org.iesalixar.servidor.trasacciones.UdPayment;

/**
 * Servlet implementation class UpdatePayment
 */
@WebServlet("/UpdatePayment")
public class UpdatePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		DaoPayments daoPayment = new DaoPayments();
		
		Payments payment = daoPayment.getPayment(Integer.parseInt((String) request.getParameter("cn")), (String) request.getParameter("checknum"));
		
		request.setAttribute("pago", payment);
		
		System.out.println(payment);
		
		request.getRequestDispatcher("WEB-INF/view/update.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

//		HttpSession session = request.getSession();
//		
		UdPayment updatePayment = new UdPayment();
//		
//		Payments payment = (Payments) session.getAttribute("pago");
		
		int customerNumber = Integer.parseInt(request.getParameter("cn"));
		String checkNumber = request.getParameter("checknum");
		String date = request.getParameter("date");
		Double cantidad = Double.parseDouble(request.getParameter("cantidad"));
		
		if (request.getParameter("cantidad") != null && request.getParameter("date") != null) {
			
//			payment.setAmount(Double.parseDouble(request.getParameter("cantidad")));
//			payment.setPaymentDate((String)request.getParameter("date"));
			
//			payment.setAmount(20.5);
//			payment.setPaymentDate("2004-05-20");
			
			
//			updatePayment.updatePaymentAmount(payment.getCustomerNumber(), payment.getCheckNumber(), payment.getAmount());
//			
//			updatePayment.updatePaymentDate(payment.getCustomerNumber(), payment.getCheckNumber(), payment.getPaymentDate());
			updatePayment.updatePaymentAmount(customerNumber, checkNumber, cantidad);
			
			updatePayment.updatePaymentDate(customerNumber, checkNumber, date);
			
			response.sendRedirect(request.getContextPath()+"/TablaPaymentsServlet");
			
			return;
		}
		
		response.sendRedirect(request.getContextPath());
	}

}
