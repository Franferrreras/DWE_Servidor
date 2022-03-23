package org.iesalixar.servidor.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.servidor.dao.ProductDaoImpl;
import org.iesalixar.servidor.model.Product;

/**
 * Servlet implementation class SerachServlet
 */
@WebServlet("/SerachServlet")
public class SerachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SerachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/view/searchProduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String search = request.getParameter("busqueda");
		
		if (search != null) {
			ProductDaoImpl productdao = new ProductDaoImpl();
			ArrayList<Product> productList = productdao.getProductByTerm(search);
			
			request.setAttribute("productos", productList);
			
			doGet(request,response);
			return;
		}
		
		doGet(request,response);
	}
	
	

}
