package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Productlines;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductLineDaoImpl plinedao = new ProductLineDaoImpl();
		EmployeeDaoImpl employee = new EmployeeDaoImpl();
		
		System.out.println(employee.getEmployees());
	}

}
