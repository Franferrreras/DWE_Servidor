package org.iesalixar.servidor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.iesalixar.servidor.db.PoolDB;
import org.iesalixar.servidor.model.Employee;

public class EmployeeDaoImpl implements EmployeeDaoI {

	@Override
	public ArrayList<Employee> getEmployees() {
		// TODO Auto-generated method stub
		
		PoolDB pool = new PoolDB();
		Connection connection = pool.getConnection();
		
		Employee e = null;
		ArrayList<Employee> listemployee = new ArrayList<Employee>();
		
		
		try {
			String sql = "SELECT * FROM employees";
			PreparedStatement statement = connection.prepareStatement(sql);
		
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				
				e = new Employee();
				e.setEmployeeNumber(rs.getInt(1));
				e.setLastName(rs.getString(2));
				e.setFirstName(rs.getString(3));
				e.setOfficeCode(rs.getString(6));
				e.setReportsTo(rs.getInt(7));
				e.setJobTitle(rs.getString(8));
				
				listemployee.add(e);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		return listemployee;
	}

	
}
