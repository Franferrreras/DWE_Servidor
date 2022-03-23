package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Payments;

public interface DaoPaymentMethod {
	
	public Payments getPayment(int customerNumber, String checkNumber);
	public ArrayList<Payments> getAllPayments();
}
