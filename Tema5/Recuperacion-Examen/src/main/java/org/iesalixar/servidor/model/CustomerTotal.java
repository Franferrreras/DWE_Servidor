package org.iesalixar.servidor.model;

public class CustomerTotal {

	private String customerName;
	private int numOrder;
	private double total;
	
	public CustomerTotal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getNumOrder() {
		return numOrder;
	}

	public void setNumOrder(int numOrder) {
		this.numOrder = numOrder;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "CustomerTotal [customerName=" + customerName + ", numOrder=" + numOrder + ", total=" + total + "]";
	}

	
}
