package org.iesalixar.servidor.dao;

import java.util.ArrayList;

import org.iesalixar.servidor.model.Employee;
import org.iesalixar.servidor.model.Employee2;

public interface Employee2DaoI {

	public ArrayList<Employee2> getEmployees();
	public ArrayList<Employee> getBoss();
}
