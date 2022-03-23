package org.iesalixar.servidor.dao;

public class Main {

	public static void main(String[] args) {
		
		UsuarioDaoImpl usuariodao = new UsuarioDaoImpl();
		PaymentDaoImpl paymentdao = new PaymentDaoImpl();
		ProductDaoImpl productdao = new ProductDaoImpl();
		
//		System.out.println(usuariodao.getAllUsuario());
		
//		usuariodao.insertUser("Jose", "jose@gmail.com", "1234", "usuario");
		
//		System.out.println(paymentdao.getListPayment());
		System.out.println(productdao.getProductByTerm("M"));
		
	}

}
