package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.servidor.db.PoolDB;
import org.iesalixar.servidor.model.Employee;

public class EmployeeDaoImpl implements EmployeeDaoI {

	@Override
	public List<Employee> getEmployeList() {
		
		PoolDB pool = new PoolDB();
		Connection connection = pool.getConnection();
		Employee e = null;
		List<Employee> list_employee = new ArrayList<Employee>();
		
		try {
			
			String sql = "SELECT * FROM employees";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				e = new Employee();
				
				e.setEmployeeNumber(rs.getInt(1));
				e.setLastName(rs.getString(2));
				e.setFirstName(rs.getString(3));
				e.setExtension(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setOfficeCode(rs.getString(6));
				e.setReportsTo(rs.getInt(7));
				e.setJobTitle(rs.getString(8));
				
				list_employee.add(e);
				
			}
			
		} catch (SQLException ex) {
			
			System.out.println(ex.getMessage());
			
		} finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		
		return list_employee;
		
	}

	@Override
	public void addEmployee(Employee e) {
		
		PoolDB pool = new PoolDB();
		Connection connection = pool.getConnection();
				
		try {
			String sql = "INSERT INTO employees values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, e.getEmployeeNumber());
			statement.setString(2, e.getLastName());
			statement.setString(3, e.getFirstName());
			statement.setString(4, e.getExtension());
			statement.setString(5, e.getEmail());
			statement.setString(6, e.getOfficeCode());
			statement.setInt(7, e.getReportsTo());
			statement.setString(8, e.getJobTitle());
			
			statement.executeUpdate();
			
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
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		PoolDB pool = new PoolDB();
		Connection connection = pool.getConnection();
		Employee e = null;
		
		try {
			
			String sql = "SELECT * FROM employees WHERE employeeNumber = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				e = new Employee();
				
				e.setEmployeeNumber(rs.getInt(1));
				e.setLastName(rs.getString(2));
				e.setFirstName(rs.getString(3));
				e.setExtension(rs.getString(4));
				e.setEmail(rs.getString(5));
				e.setOfficeCode(rs.getString(6));
				e.setReportsTo(rs.getInt(7));
				e.setJobTitle(rs.getString(8));
				
			}
			
		} catch (SQLException ex) {
			
			System.out.println(ex.getMessage());
			
		} finally {
			try {
				connection.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		
		return e;
	}

}
