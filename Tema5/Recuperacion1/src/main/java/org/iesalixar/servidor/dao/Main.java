package org.iesalixar.servidor.dao;

public class Main {

	public static void main(String[] args) {
		
		ProductLineDaoImpl prodao = new ProductLineDaoImpl();
		
		System.out.println(prodao.getProductsByCategory("Classic Cars"));

	}

}
