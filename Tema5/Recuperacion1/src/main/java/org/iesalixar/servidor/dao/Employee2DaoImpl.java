package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.db.PoolDB;
import org.iesalixar.servidor.model.Employee;
import org.iesalixar.servidor.model.Employee2;

public class Employee2DaoImpl implements Employee2DaoI {

	@Override
	public ArrayList<Employee2> getEmployees() {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PoolDB pool = new PoolDB();
		connection = pool.getConnection();
		
		ArrayList<Employee2> list_employee = new ArrayList<Employee2>();
		Employee2 e = null;
		
		try {
			String sql = "select e.employeeNumber , e.lastName , e.firstName , e.jobTitle , o.city , CONCAT(e2.firstName, \" \" ,e2.lastName) jefe from employees e inner join offices o on o.officeCode  = e.officeCode inner join employees e2 on e2.employeeNumber = e.employeeNumber GROUP BY e.employeeNumber";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				e = new Employee2();
				
				e.setEmployeeNumber(rs.getInt(1));
				e.setLastName(rs.getString(2));
				e.setFirstName(rs.getString(3));
				e.setJobTitle(rs.getString(4));
				e.setOffice(rs.getString(5));
				e.setReportsTo(rs.getString(6));
				
				list_employee.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.getMessage());
			}
		}
		
		return list_employee;
		
	}

	@Override
	public ArrayList<Employee> getBoss() {
		
		Connection connection = null;
		PoolDB pool = new PoolDB();
		connection = pool.getConnection();
		
		ArrayList<Employee> list_boss = new ArrayList<Employee>();
		Employee e = null;
				
		try {
			String sql ="SELECT e.reportsTo, e.firstName , e.lastName FROM employees e group by e.reportsTo";

			PreparedStatement statement = connection.prepareStatement(sql);
		
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				e = new Employee();
				
				e.setReportsTo(rs.getInt(1));
				e.setFirstName(rs.getString(2));
				e.setLastName(rs.getString(3));
				
				list_boss.add(e);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return list_boss;
	}

}
