package org.iesalixar.servidor.dao;

import java.util.List;

import org.iesalixar.servidor.model.Employee;

public interface EmployeeDaoI {

	public List<Employee> getEmployeList();
	public void addEmployee(Employee e);
}
