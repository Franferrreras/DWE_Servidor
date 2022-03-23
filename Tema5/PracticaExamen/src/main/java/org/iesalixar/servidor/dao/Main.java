package org.iesalixar.servidor.dao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsuarioDaoImpl usuariodao = new UsuarioDaoImpl();
		
		ProductDaoImpl productdao = new ProductDaoImpl();
		
		
		System.out.println(productdao.getProducts());
		
	}

}
