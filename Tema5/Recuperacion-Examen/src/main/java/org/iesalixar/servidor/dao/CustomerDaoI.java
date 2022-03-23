package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Customer;
import org.iesalixar.servidor.model.CustomerTotal;

public interface CustomerDaoI {

	public ArrayList<Customer> getCustomers();
	public void updateCustomerSalesRep(int idcustomer, int idem);
	public CustomerTotal getTotal(int customerNumber);
}
