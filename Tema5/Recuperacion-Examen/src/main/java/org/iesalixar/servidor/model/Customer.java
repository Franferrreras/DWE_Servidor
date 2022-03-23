package org.iesalixar.servidor.model;

import java.io.Serializable;

public class Customer implements Serializable{

	private int customerNumber;
	private String customerName;
	private String contactLastName;
	private String contactFirsttName;
	private String phone;
	private int salesEmployeeNumber;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getContactFirsttName() {
		return contactFirsttName;
	}

	public void setContactFirsttName(String contactFirsttName) {
		this.contactFirsttName = contactFirsttName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getSalesEmployeeNumber() {
		return salesEmployeeNumber;
	}

	public void setSalesEmployeeNumber(int salesEmployeeNumber) {
		this.salesEmployeeNumber = salesEmployeeNumber;
	}

	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", customerName=" + customerName + ", contactLastName="
				+ contactLastName + ", contactFirsttName=" + contactFirsttName + ", phone=" + phone
				+ ", salesEmployeeNumber=" + salesEmployeeNumber + "]";
	}
	
	
}
