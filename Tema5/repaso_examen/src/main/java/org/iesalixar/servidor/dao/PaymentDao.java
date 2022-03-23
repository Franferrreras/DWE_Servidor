package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Payment;

public interface PaymentDao {

	public ArrayList<Payment> getListPayment();
	public Payment getPayment();
}
