package org.iesalixadr.servidor.dao;

import java.util.ArrayList;

import org.iesalixadr.servidor.model.Customer;

public interface CustomerDaoI {

	public ArrayList<Customer> getCustomers();
	public void updateCustomerSalesRep(int idcustomer, int idem);
}
