package org.iesalixar.servidor.dao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioDaoImpl usuariodao = new UsuarioDaoImpl();
		OfficeDaoImpl officedao = new OfficeDaoImpl();
//		usuariodao.insertUser("diana", "diana@gmail.com", "1234", "usuario", "a1", "a2");
		
		System.out.println(officedao.getOffice("San Francisco"));
	}

}
