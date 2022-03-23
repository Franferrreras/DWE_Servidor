package org.iesalixar.servidor.dao;

public class Main {

	public static void main(String[] args) {
		CustomerDaoImpl customerdao = new CustomerDaoImpl();
		
		customerdao.updateCustomerSalesRep(103, 1166);
		
	}
}
