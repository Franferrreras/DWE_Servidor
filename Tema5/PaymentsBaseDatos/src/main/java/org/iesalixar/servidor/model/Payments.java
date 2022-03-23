package org.iesalixar.servidor.model;

import java.io.Serializable;

public class Payments implements Serializable {
	
	private int customerNumber;
	private String checkNumber;
	private String paymentDate;
	private double amount;

	public Payments() {
		// TODO Auto-generated constructor stub
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return  "\n" + 
				"customerNumber = " + customerNumber + "\n" +
				"checkNumber = " + checkNumber + "\n" +
				"paymentDate = "+ paymentDate + "\n" +
				"amount = " + amount + "\n" + "_________________" + "\n";
	}

}
